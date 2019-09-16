package com.dedu.mall.model.mysql;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoryVo {
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isEnable;
    private Boolean isDelete;
    private List<CategoryVo> children;
}
