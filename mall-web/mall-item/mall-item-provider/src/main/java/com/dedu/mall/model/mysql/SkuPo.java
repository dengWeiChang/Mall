package com.dedu.mall.model.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "tb_sku")
public class SkuPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "spu_id")
    private Long spuId;
    @TableField(value = "title")
    private String title;
    @TableField(value = "images")
    private String images;
    @TableField(value = "price")
    private BigDecimal price;
    @TableField(value = "specs")
    private String specs;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
    @TableField(value = "is_enable")
    private Boolean isEnable;
    @TableField(value = "is_delete")
    private Boolean isDelete;
}
