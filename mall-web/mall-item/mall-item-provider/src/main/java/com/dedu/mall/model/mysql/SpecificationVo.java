package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecificationVo {
    private Long id;
    private String name;
    private String value;
    private Boolean searchable;
    private Boolean global;
    private String unit;
    private Long groupId;
    private String groupName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
