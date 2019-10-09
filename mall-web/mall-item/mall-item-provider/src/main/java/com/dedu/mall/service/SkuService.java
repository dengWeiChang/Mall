package com.dedu.mall.service;

import com.dedu.mall.model.mysql.SkuPo;
import com.dedu.mall.model.mysql.SkuVo;

public interface SkuService {
    SkuPo addSku(SkuVo skuVo);
}
