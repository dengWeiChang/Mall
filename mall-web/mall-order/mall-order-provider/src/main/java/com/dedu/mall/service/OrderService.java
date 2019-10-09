package com.dedu.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dedu.mall.model.mysql.OrderAllInfoPo;
import com.dedu.mall.model.mysql.OrderDetailPo;

public interface OrderService {

    IPage<OrderAllInfoPo> getOrderPage(Integer pageNum, Integer pageSize);

    OrderDetailPo queryOrderDetailById(Long id);
}
