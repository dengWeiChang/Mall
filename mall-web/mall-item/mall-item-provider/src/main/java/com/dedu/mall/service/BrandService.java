package com.dedu.mall.service;

import com.dedu.mall.model.mysql.BrandVo;

public interface BrandService {
    Object getBrandPage(Integer pageNum, Integer pageSize);

    Object addBrand(BrandVo brand) throws Exception;

    boolean deleteBrandById(Long id);

    boolean modifyInfoById(BrandVo brand) throws Exception;
}
