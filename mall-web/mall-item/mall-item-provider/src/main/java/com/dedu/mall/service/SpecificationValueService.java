package com.dedu.mall.service;

import com.dedu.mall.model.mysql.SpecificationValuePo;
import com.dedu.mall.model.mysql.SpecificationValueVo;

import java.util.List;

public interface SpecificationValueService {
    List<SpecificationValuePo> addSpecificationValueBatch(List<SpecificationValueVo> specVoList);
}
