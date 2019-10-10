package com.dedu.mall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkuVo {
    private Long id;
    private Long spuId;
    private String title;
    private String images;
    private BigDecimal price;
    private String specs;
    private String specValues;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isEnable;
    private Boolean isDelete;
}
