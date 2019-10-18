package com.dedu.mall.service;

import com.dedu.mall.model.mysql.SpecialVo;

public interface SpecialService {
    SpecialVo getSpecialByType(int type);
}
