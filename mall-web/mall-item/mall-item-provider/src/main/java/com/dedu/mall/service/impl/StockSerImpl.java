package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.StockMapper;
import com.dedu.mall.model.mysql.StockPo;
import com.dedu.mall.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockSerImpl extends ServiceImpl<StockMapper, StockPo> implements StockService {

}
