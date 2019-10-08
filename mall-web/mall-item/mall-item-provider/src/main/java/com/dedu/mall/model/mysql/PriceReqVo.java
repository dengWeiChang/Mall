package com.dedu.mall.model.mysql;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceReqVo {
    private String specs;
    private String specNames;
    private BigDecimal price;
    private BigDecimal stock;
}
