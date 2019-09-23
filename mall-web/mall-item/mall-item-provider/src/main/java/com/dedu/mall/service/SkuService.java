package com.dedu.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dedu.mall.model.mysql.SpuVo;

public interface SkuService {
    IPage<SpuVo> getSpuPage(Integer pageNum, Integer pageSize);
}
