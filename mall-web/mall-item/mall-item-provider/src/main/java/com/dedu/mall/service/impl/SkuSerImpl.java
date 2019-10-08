package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SkuMapper;
import com.dedu.mall.model.mysql.SkuPo;
import com.dedu.mall.model.mysql.SkuVo;
import com.dedu.mall.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class SkuSerImpl extends ServiceImpl<SkuMapper, SkuPo> implements SkuService {

    @Override
    public void addSku(SkuVo skuVo) {
        SkuPo skuPo = new SkuPo();
        BeanUtils.copyProperties(skuVo, skuPo);
        skuPo.setCreateTime(LocalDateTime.now());
        skuPo.setUpdateTime(LocalDateTime.now());
        skuPo.setIsEnable(Boolean.TRUE);
        skuPo.setIsDelete(Boolean.FALSE);
        this.save(skuPo);

    }
}
