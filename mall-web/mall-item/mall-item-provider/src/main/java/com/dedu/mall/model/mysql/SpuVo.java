package com.dedu.mall.model.mysql;

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
public class SpuVo {
    private Long spuId;
    private String spuTitle;
    private String spuSubTitle;
    /**
     * 展示图片
     */
    private String image;
    /**
     * 所有图片
     */
    private String images;
    private Integer saleable;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
