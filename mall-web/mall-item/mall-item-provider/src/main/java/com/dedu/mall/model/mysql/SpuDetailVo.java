package com.dedu.mall.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpuDetailVo {
    private Long id;
    private Long spuId;
    private String description;
    private String packingList;
    private String afterService;
}
