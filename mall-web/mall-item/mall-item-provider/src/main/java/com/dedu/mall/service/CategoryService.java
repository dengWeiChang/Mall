package com.dedu.mall.service;

import com.dedu.mall.model.mysql.CategoryNavVo;
import com.dedu.mall.model.mysql.CategorySelectorVo;
import com.dedu.mall.model.mysql.CategoryVo;

import java.util.List;

public interface CategoryService {
    List<CategoryVo> getAllCategoryTreeByParentId(Integer parentId);

    List<CategorySelectorVo> getAllCategoryList();

    boolean modifyInfoById(CategoryVo categoryVo) throws Exception;

    boolean removeCategoryById(Long id);

    boolean addCategory(CategoryVo request);

    List<CategoryNavVo> getAllCategoryNavList();
}
