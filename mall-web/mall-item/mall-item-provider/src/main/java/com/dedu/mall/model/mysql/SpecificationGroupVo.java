package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecificationGroupVo {
    private Long id;
    private String name;
    private Long categoryId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    List<SpecificationVo> specs;
}
