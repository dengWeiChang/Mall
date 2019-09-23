package com.dedu.mall.model.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "tb_stock")
public class StockPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "sku_id")
    private Long skuId;
    @TableField(value = "seckill_stock")
    private Integer seckillStock;
    @TableField(value = "seckill_total")
    private Integer seckillTotal;
    @TableField(value = "stock")
    private Integer stock;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
    @TableField(value = "is_enable")
    private Boolean isEnable;
    @TableField(value = "is_delete")
    private Boolean isDelete;
}
