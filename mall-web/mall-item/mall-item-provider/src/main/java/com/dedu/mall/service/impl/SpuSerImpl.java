package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SpuMapper;
import com.dedu.mall.model.mysql.SpuPo;
import com.dedu.mall.service.SpuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpuSerImpl extends ServiceImpl<SpuMapper, SpuPo> implements SpuService {

}
