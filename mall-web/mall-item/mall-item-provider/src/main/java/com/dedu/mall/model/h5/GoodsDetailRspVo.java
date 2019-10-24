package com.dedu.mall.model.h5;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsDetailRspVo {
    private List<String> goodsImg;
    private String title;
    private List<String> tags;
    private List<String> discount;
    private List<String> promotion;
    private Integer remarksNum;
    private List<String> setMeal;
    private List<String> hot;
    private List<String> goodsDetail;
    private List<String> param;

}
