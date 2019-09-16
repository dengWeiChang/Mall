package com.dedu.mall.model.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "tb_category")
public class TCategory {
    @TableId
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "parent_id")
    private Long parentId;
    @TableField(value = "is_parent")
    private Boolean isParent;
    @TableField(value = "sort")
    private Integer sort;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
    @TableField(value = "is_enable")
    private Boolean isEnable;
    @TableField(value = "is_delete")
    private Boolean isDelete;
}
