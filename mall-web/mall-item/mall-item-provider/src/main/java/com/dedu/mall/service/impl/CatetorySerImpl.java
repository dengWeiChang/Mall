package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.CategoryMapper;
import com.dedu.mall.model.mysql.CategoryPo;
import com.dedu.mall.model.mysql.CategorySelectorVo;
import com.dedu.mall.model.mysql.CategoryVo;
import com.dedu.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatetorySerImpl extends ServiceImpl<CategoryMapper, CategoryPo> implements CategoryService {

    @Override
    public List<CategoryVo> getAllCategoryTreeByParentId(Integer parentId) {
        //查询所有顶级类目
        // 第一层类目
        List<CategoryPo> catPoList = this.list(new QueryWrapper<CategoryPo>().eq("parent_id", parentId).eq("is_delete", 0));
        List<CategoryVo> catVoList = new ArrayList<>();
        for (CategoryPo catPo:
        catPoList) {
            CategoryVo catVo = new CategoryVo();
            BeanUtils.copyProperties(catPo, catVo);
            if (null != catVo.getIsParent() && catVo.getIsParent()) {
                // 第二层类目
                List<CategoryPo> secondCategoryList = getAllCategoryByParentId(catVo.getId());
                List<CategoryVo> secondCatVoList = new ArrayList<>();
                for (CategoryPo secondCatPo:
                secondCategoryList) {
                    CategoryVo secondCatVo = new CategoryVo();
                    BeanUtils.copyProperties(secondCatPo, secondCatVo);
                    if (null != secondCatVo.getIsParent() && secondCatVo.getIsParent()) {
                        // 第三层类目
                        List<CategoryPo> thirdCategoryList = getAllCategoryByParentId(secondCatVo.getId());
                        List<CategoryVo> thirdCatVoList = new ArrayList<>();
                        for (CategoryPo thirdPo:
                                thirdCategoryList) {
                            CategoryVo thirdCatVo = new CategoryVo();
                            BeanUtils.copyProperties(thirdPo, thirdCatVo);
                            thirdCatVoList.add(thirdCatVo);
                        }
                        secondCatVo.setChildren(thirdCatVoList);
                    }

                    secondCatVoList.add(secondCatVo);
                }
                catVo.setChildren(secondCatVoList);
            }
            catVoList.add(catVo);
        }
        return catVoList;
    }

    @Override
    public List<CategorySelectorVo> getAllCategoryList() {
        List<CategorySelectorVo> result = new ArrayList<>();
        List<CategoryVo> allCategoryList = getAllCategoryTreeByParentId(0);
        collectCategorySelector(result, allCategoryList, "");
        result.add(CategorySelectorVo.builder().id(0L).name("无").build());
        return result;
    }


    @Override
    public boolean modifyInfoById(CategoryVo categoryVo) throws Exception {
        if (null == categoryVo.getId()) {
            throw new Exception("修改类目时，Id不能为空");
        }
        CategoryPo categoryPo = new CategoryPo();
        BeanUtils.copyProperties(categoryVo, categoryPo);
        return this.updateById(categoryPo);
    }

    @Override
    public boolean deleteCategoryById(Long id) {
//        return this.update(CategoryPo.builder().isDelete(true).build(), new QueryWrapper<CategoryPo>().eq("id", id).eq("isDelete", false));
        return this.updateById(CategoryPo.builder().id(id).isDelete(true).build());
    }

    private List<CategoryPo> getAllCategoryByParentId(Long parentId) {
        return this.list(new QueryWrapper<CategoryPo>().eq("parent_id", parentId).eq("is_enable", "1").eq("is_delete", 0));
    }

    /**
     * 递归一次收集类目
     * @param result
     * @param allCategoryList
     */
    private void collectCategorySelector(List<CategorySelectorVo> result, List<CategoryVo> allCategoryList, String prefix) {
        for (CategoryVo catVo: allCategoryList) {
            result.add(CategorySelectorVo.builder().id(catVo.getId()).name(prefix + catVo.getName()).build());
            if (!CollectionUtils.isEmpty(catVo.getChildren())) {
                collectCategorySelector(result, catVo.getChildren(), catVo.getName() + "-");
            }
        }

    }
}
