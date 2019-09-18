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
@TableName(value = "tb_brand")
public class BrandPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "image")
    private String image;
    @TableField(value = "letter")
    private String letter;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
    @TableField(value = "is_enable")
    private Boolean isEnable;
    @TableField(value = "is_delete")
    private Boolean isDelete;
}
