package com.dedu.mall.model.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "tb_order_status")
public class OrderStatusPo {
    @TableId(value = "id", type = AUTO)
    private Long id;
    @TableField(value = "order_id")
    private Long orderId;
    @TableField(value = "status")
    private Integer status;
    @TableField(value = "consign_time")
    private LocalDateTime consignTime;
    @TableField(value = "end_time")
    private LocalDateTime endTime;
    @TableField(value = "close_time")
    private LocalDateTime closeTime;
    @TableField(value = "comment_time")
    private LocalDateTime commentTime;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}
