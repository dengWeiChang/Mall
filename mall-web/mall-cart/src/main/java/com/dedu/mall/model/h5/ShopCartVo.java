package com.dedu.mall.model.h5;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShopCartVo {
    private Long goodsId;
    private Integer count;
    private String img;
    private String packages;
    private BigDecimal price;
    private String title;
}
