package com.dedu.mall.model.mysql;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GoodsNavVo {
    private String navName;
    private List<String> navValues;
}
