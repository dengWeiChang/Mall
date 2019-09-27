package com.dedu.mall.service;

import com.dedu.mall.model.mysql.BrandVo;

import java.util.List;

public interface CategoryBrandRelationService {
    List<BrandVo> queryBrandsByCategoryId(Long categoryId);
}
