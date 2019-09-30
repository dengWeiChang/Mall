package com.dedu.mall.model.mysql;

import lombok.Data;

import java.util.List;

@Data
public class SpecReqVo {
    private Long specId;
    private String specName;
    private List<SpecReqVo> checkList;
    private String specValue;
}
