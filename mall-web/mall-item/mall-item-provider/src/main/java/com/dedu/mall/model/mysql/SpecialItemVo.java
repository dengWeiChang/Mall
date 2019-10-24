package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialItemVo {
    private String title;
    private String intro;
    private String img;
    private String content;
}
