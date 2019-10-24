package com.dedu.mall.service.impl;

import com.dedu.mall.model.Result;
import com.dedu.mall.model.h5.GoodsDetailRspVo;
import com.dedu.mall.model.h5.GoodsRspVo;
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

    @Override
    public List<GoodsNavVo> queryGoodsNavByCategoryId(Long id) {
        List<GoodsNavVo> result = new ArrayList<>();
        String[] g1Arr = {"华为(HUAWEI)1", "三星(SAMSUNG)", "MATE", "摩斯维(msvii)", "OPPO", "莫凡(Mofi)", "耐尔金(NILLKIN)", "洛克(ROCK)", "亿色(ESR)", "Apple", "优加"};
        GoodsNavVo g1 = GoodsNavVo.builder().navName("品牌").navValues(CollectionUtils.arrayToList(g1Arr)).build();
        String[] g2Arr = {"手机保护套", "苹果周边", "手机贴膜", "移动电源", "创意配件", "手机耳机", "手机支架"};
        GoodsNavVo g2 = GoodsNavVo.builder().navName("手机配件").navValues(CollectionUtils.arrayToList(g2Arr)).build();
        String[] g3Arr = {"软壳", "硬壳", "翻盖式", "边框", "运动臂包", "钱包式", "定制", "防水袋", "布袋", "其他"};
        GoodsNavVo g3 = GoodsNavVo.builder().navName("款式").navValues(CollectionUtils.arrayToList(g3Arr)).build();
        String[] g4Arr = {"塑料/PC", "硅胶", "金属", "电镀", "真皮", "树脂", "木质", "镶钻", "液态硅胶", "TPU"};
        GoodsNavVo g4 = GoodsNavVo.builder().navName("材质").navValues(CollectionUtils.arrayToList(g4Arr)).build();

        result.add(g1);
        result.add(g2);
        result.add(g3);
        result.add(g4);
        return result;
    }

    /**
     * 根据类目查询商品列表和广告列表
     * @param id
     * @return
     */
    @Override
    public GoodsListVo queryGoodsListByCategoryId(Long id) {
        List<GoodsRspVo> adList = new ArrayList<>(6);
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-1.jpg").price(new Double("39.9")).intro("SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬").num(3140).sale(new Double("9000")).build());
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-2.jpg").price(new Double("49.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").num(1160).sale(new Double("5900")).build());
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-1.jpg").price(new Double("59.9")).intro("SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬").num(5160).sale(new Double("8800")).build());
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-2.jpg").price(new Double("69.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").num(6160).sale(new Double("7700")).build());
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-1.jpg").price(new Double("79.9")).intro("SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬").num(7160).sale(new Double("6600")).build());
        adList.add(GoodsRspVo.builder().img("static/img/goodsList/item-as-img-2.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").num(9160).sale(new Double("5500")).build());
        List<GoodsRspVo> goodsList = new ArrayList<>();
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-1.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("歌乐力手配专营店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-2.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("BIAZE官方旗舰店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-3.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("歌乐力手配专营店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-4.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("BIAZE官方旗舰店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-5.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("歌乐力手配专营店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-6.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("monqiqi旗舰店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-7.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("BIAZE官方旗舰店").sale(new Double("5500")).build());
        goodsList.add(GoodsRspVo.builder().img("static/img/goodsList/item-show-8.jpg").price(new Double("89.9")).intro("狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外").remarks(9000).shopName("monqiqi旗舰店").sale(new Double("5500")).build());
        GoodsListVo result = GoodsListVo.builder().advertisingList(adList).goodsList(goodsList).build();
        return result;
    }

    @Override
    public GoodsDetailRspVo queryGoodsById(Long id) {
        return null;
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
