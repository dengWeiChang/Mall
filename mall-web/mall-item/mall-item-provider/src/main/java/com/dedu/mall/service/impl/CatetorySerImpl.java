package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.CategoryMapper;
import com.dedu.mall.model.mysql.CategoryPo;
import com.dedu.mall.model.mysql.CategoryVo;
import com.dedu.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatetorySerImpl extends ServiceImpl<CategoryMapper, CategoryPo> implements CategoryService {

    @Override
    public List<CategoryVo> getAllCategoryTree() {
        //查询所有顶级类目
        // 第一层类目
        List<CategoryPo> catPoList = this.list(new QueryWrapper<CategoryPo>().eq("parent_id", "0").eq("is_delete", 0));
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

    public List<CategoryPo> getAllCategoryByParentId(Long parentId) {
        return this.list(new QueryWrapper<CategoryPo>().eq("parent_id", parentId).eq("is_enable", "1").eq("is_delete", 0));
    }

}
