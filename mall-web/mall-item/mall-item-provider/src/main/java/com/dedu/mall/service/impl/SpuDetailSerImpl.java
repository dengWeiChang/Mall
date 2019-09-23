package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.SpuDetailMapper;
import com.dedu.mall.model.mysql.SpuDetailPo;
import com.dedu.mall.service.SpuDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpuDetailSerImpl extends ServiceImpl<SpuDetailMapper, SpuDetailPo> implements SpuDetailService {

}
