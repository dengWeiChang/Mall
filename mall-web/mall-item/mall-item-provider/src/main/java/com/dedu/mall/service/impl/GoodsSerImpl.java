package com.dedu.mall.service.impl;

import com.dedu.mall.model.mysql.*;
import com.dedu.mall.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GoodsSerImpl implements GoodsService {

    @Autowired
    private SpuService spuService;

    @Autowired
    private SpecificationService specService;

    @Autowired
    private SpecificationValueService specValueService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private StockService stockService;

    @Override
    public Boolean addGoods(GoodsVo goodsVo) {
        // 1插入SPU 和 插入SPUDetail
        SpuAndDetailVo spuAndDetailVo = convertGoodsToSpuAndDetail(goodsVo);
        SpuPo savedSpuPo = spuService.addSpuAndSpuDetail(spuAndDetailVo);
        // 2插入SpecificationValue
        Map<String, Long> tempCache = new HashMap<>();
        String pictures = "";
        if (!CollectionUtils.isEmpty(goodsVo.getSpecs())) {
            if (!CollectionUtils.isEmpty(goodsVo.getPictures())) {
                pictures = goodsVo.getPictures().stream().map(PictureReqVo::getUrl).collect(Collectors.joining(","));
            }
            for (SpecReqVo specReqVo:goodsVo.getSpecs()
                 ) {
                List<SpecReqVo> checkList = specReqVo.getCheckList();
                List<SpecificationValueVo> specValueVoList = new ArrayList<>();
                checkList.stream().forEach(s ->
                    specValueVoList.add(SpecificationValueVo.builder()
                            .specificationId(s.getSpecId())
                            .specificationName(specReqVo.getSpecName())
                            .value(s.getSpecValue())
                            .build()));
                List<SpecificationValuePo> specificationValuePos = specValueService.addSpecificationValueBatch(specValueVoList);
                Map<String, Long> collect = specificationValuePos.stream().collect(Collectors.toMap(SpecificationValuePo::getValue, SpecificationValuePo::getId));
                tempCache.putAll(collect);
            }
        }
        // 3插入SKU
        if (!CollectionUtils.isEmpty(goodsVo.getPrices())) {
            Map<Long, BigDecimal> stockMap = new HashMap<>();
            for (PriceReqVo priceReqVo:
            goodsVo.getPrices()) {
                String specs = priceReqVo.getSpecs();
                String specValues = getSpecValues(tempCache, priceReqVo.getSpecNames());
                SkuPo skuPo = skuService.addSku(SkuVo.builder()
                        .spuId(savedSpuPo.getId())
                        .title(goodsVo.getName())
                        .images(pictures)
                        .price(priceReqVo.getPrice())
                        .specs(specs)
                        .specValues(specValues)
                        .build());
                if (null != skuPo) {
                    stockMap.put(skuPo.getId(), priceReqVo.getStock());
                }
            }
            // 4 插入Stock
            stockService.addStockByMapBatch(stockMap);
        }
        return true;
    }

    /**
     * 获取规格参数值主键，并使用,分隔
     * @param tempCache
     * @param specNames
     * @return
     */
    private String getSpecValues(Map<String, Long> tempCache, String specNames) {
        String[] specNameSplits = specNames.split("\\,");
        StringBuilder sb = new StringBuilder();
        for (String specName:
        specNameSplits) {
            Long specValueId = tempCache.get(specName);
            if (null != specValueId) {
                sb.append(specValueId.toString()).append("\\,");
            }
        }
        return sb.toString();
    }

    /**
     * 将前端GoodsVo转换成数据库对象
     * @param goodsVo
     * @return
     */
    private SpuAndDetailVo convertGoodsToSpuAndDetail(GoodsVo goodsVo) {
        return SpuAndDetailVo.builder()
                .title(goodsVo.getName())
                .subTitle(goodsVo.getSubtitle())
                .categotyIds(goodsVo.getCategoryId().toString())
                .brandId(goodsVo.getBrand())
                .saleable(Boolean.TRUE)
                .spuDetailVo(SpuDetailVo.builder()
                        .description(goodsVo.getDesc())
                        .packingList(goodsVo.getPacklist())
                        .afterService(goodsVo.getService())
                        .build())
                .build();

    }
}
