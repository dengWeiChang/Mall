package com.dedu.mall.model.mysql;

import com.dedu.mall.model.h5.GoodsRspVo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsListVo {
    /**
     * 广告推荐列表
     */
    private List<GoodsRspVo> advertisingList;
    /**
     * 商品列表
     */
    private List<GoodsRspVo> goodsList;
}
