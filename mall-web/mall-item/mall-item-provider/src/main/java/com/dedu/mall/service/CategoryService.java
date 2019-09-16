package com.dedu.mall.service;

import com.dedu.mall.model.mysql.CategoryVo;

import java.util.List;

public interface CategoryService {
    List<CategoryVo> getAllCategoryTree();
}
