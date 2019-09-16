package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.CategoryMapper;
import com.dedu.mall.model.mysql.TCategory;
import com.dedu.mall.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CatetorySerImpl extends ServiceImpl<CategoryMapper, TCategory> implements CategoryService {

}
