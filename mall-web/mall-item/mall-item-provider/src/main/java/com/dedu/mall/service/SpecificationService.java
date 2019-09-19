package com.dedu.mall.service;

import com.dedu.mall.model.mysql.SpecificationPo;

import java.util.List;

public interface SpecificationService {
    List<SpecificationPo> queryByGroupIds(List<Long> groupIdList) throws Exception;
}
