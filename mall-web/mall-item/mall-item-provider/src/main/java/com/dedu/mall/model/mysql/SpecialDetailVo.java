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
public class SpecialDetailVo {
    private String bigImg;
    private List<SpecialItemVo> itemFour;
    private List<String> itemContent;
}
