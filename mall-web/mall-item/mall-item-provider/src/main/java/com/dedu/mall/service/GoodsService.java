package com.dedu.mall.service;

import com.dedu.mall.model.mysql.GoodsNavVo;
import com.dedu.mall.model.mysql.GoodsVo;

import java.util.List;

public interface GoodsService {
    Boolean addGoods(GoodsVo goodsVo);

    List<GoodsNavVo> queryGoodsNavByCategoryId(Long id);
}
