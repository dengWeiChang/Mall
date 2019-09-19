package com.dedu.mall.service;

import com.dedu.mall.model.mysql.SpecificationGroupVo;

import java.util.List;

public interface SpecificationGroupService {
    List<SpecificationGroupVo> queryByCategoryId(Long id) throws Exception;
}
