package com.dedu.mall.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SkuMapper;
import com.dedu.mall.dao.SpuMapper;
import com.dedu.mall.model.mysql.SkuPo;
import com.dedu.mall.model.mysql.SpuVo;
import com.dedu.mall.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class SkuSerImpl extends ServiceImpl<SkuMapper, SkuPo> implements SkuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public IPage<SpuVo> getSpuPage(Integer pageNum, Integer pageSize) {
        IPage<SpuVo> result = new Page<>();
        List<SpuVo> data = spuMapper.selectSpuPage(new Page<>(pageNum, pageSize));
        Integer count = spuMapper.selectSpuCount();
        if (!CollectionUtils.isEmpty(data)) {
            data.stream().forEach(t->{
                //,分隔   获取首长图片
                String images = t.getImages();
                if (!StringUtils.isEmpty(images)) {
                    String[] splitimages = images.split("\\,");
                    t.setImage(splitimages[0] == null?"": splitimages[0]);
                }
            });
        }
        result.setTotal(count);
        result.setRecords(data);
        result.setCurrent(pageNum);
        result.setSize(pageSize);
        return result;
    }
}
