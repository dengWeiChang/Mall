package com.dedu.mall.model.mysql;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpuAndDetailVo {
    private String title;
    private String subTitle;
    private String categotyIds;
    private String categotyNames;
    private Long brandId;
    private Boolean saleable;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isEnable;
    private Boolean isDelete;
    private SpuDetailVo spuDetailVo;
}
