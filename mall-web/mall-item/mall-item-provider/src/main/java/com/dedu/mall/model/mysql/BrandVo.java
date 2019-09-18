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
public class BrandVo {
    private Long id;
    private String name;
    private String image;
    private String letter;
    private List<String> category;
}
