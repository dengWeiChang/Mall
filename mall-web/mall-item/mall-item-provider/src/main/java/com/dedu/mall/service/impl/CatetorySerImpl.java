package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.CategoryMapper;
import com.dedu.mall.model.mysql.*;
import com.dedu.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatetorySerImpl extends ServiceImpl<CategoryMapper, CategoryPo> implements CategoryService {

    @Override
    public List<CategoryNavVo> getAllCategoryNavList() {
        List<CategoryNavVo> result = new ArrayList<>(14);

        String[] navTagArr = {"清洁用品", "美妆商城", "美妆馆", "妆比社", "全球购美妆", "宠物馆"};
        List<String> navTags = CollectionUtils.arrayToList(navTagArr);

        List<CategoryNavItem> navItems = new ArrayList<>();
        navItems.add(createCategoryNavItem("面部护肤",
                new String[]{"补水保湿", "卸妆", "洁面", "爽肤水", "乳液面霜", "精华", "眼霜", "防晒", "面膜", "剃须", "套装"}));
        navItems.add(createCategoryNavItem("洗发护发",
                new String[]{"洗发", "护发", "染发", "造型", "假发", "美发工具", "套装"}));
        navItems.add(createCategoryNavItem("身体护理",
                new String[]{"补水保湿", "沐浴", "润肤", "精油", "颈部", "手足", "纤体塑形", "美胸", "套装"}));
        navItems.add(createCategoryNavItem("口腔护理",
                new String[]{"牙膏/牙粉", "牙刷/牙线", "漱口水", "套装"}));
        navItems.add(createCategoryNavItem("香水彩妆",
                new String[]{"BB霜", "化妆棉", "女士香水", "男士香水", "底妆", "眉笔", "睫毛膏", "眼线", "眼影", "唇膏/彩"}));

        result.add(CategoryNavVo.builder().navTags(navTags).navItems(navItems).build());
        return result;
    }

    private CategoryNavItem createCategoryNavItem(String title, String[] navItemTagArr) {
        List<String> navItemTags = CollectionUtils.arrayToList(navItemTagArr);
        return CategoryNavItem.builder().title(title).tags(navItemTags).build();
    }

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
                if (!CollectionUtils.isEmpty(secondCategoryList)) {
                    List<CategoryVo> secondCatVoList = new ArrayList<>();
                    for (CategoryPo secondCatPo:
                            secondCategoryList) {
                        CategoryVo secondCatVo = new CategoryVo();
                        BeanUtils.copyProperties(secondCatPo, secondCatVo);
                        if (null != secondCatVo.getIsParent() && secondCatVo.getIsParent()) {
                            // 第三层类目
                            List<CategoryPo> thirdCategoryList = getAllCategoryByParentId(secondCatVo.getId());
                            if (!CollectionUtils.isEmpty(thirdCategoryList)) {
                                List<CategoryVo> thirdCatVoList = new ArrayList<>();
                                for (CategoryPo thirdPo:
                                        thirdCategoryList) {
                                    CategoryVo thirdCatVo = new CategoryVo();
                                    BeanUtils.copyProperties(thirdPo, thirdCatVo);
                                    thirdCatVoList.add(thirdCatVo);
                                }
                            }
                        }
                        secondCatVoList.add(secondCatVo);
                    }
                    catVo.setChildren(secondCatVoList);
                }
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
    public boolean removeCategoryById(Long id) {
//        return this.update(CategoryPo.builder().isDelete(true).build(), new QueryWrapper<CategoryPo>().eq("id", id).eq("isDelete", false));
        return this.updateById(CategoryPo.builder().id(id).isDelete(true).build());
    }

    @Override
    public boolean addCategory(CategoryVo request) {
        CategoryPo categoryPo = new CategoryPo();
        BeanUtils.copyProperties(request, categoryPo);
        categoryPo.setId(null);
        if (null == request.getParentId()) {
            categoryPo.setParentId(0L);
        }
        categoryPo.setCreateTime(LocalDateTime.now());
        categoryPo.setUpdateTime(LocalDateTime.now());
        return this.save(categoryPo);
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
