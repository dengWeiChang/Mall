package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeckillVo {
    List<SeckillInfoVo> info;
    /**
     * 秒杀倒计时 小时
     */
    private Integer hours;
    /**
     * 秒杀倒计时 分钟
     */
    private Integer minute;
    /**
     * 秒杀倒计时 秒数
     */
    private Integer seconds;
}
