package com.dedu.mall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dedu.mall.dao.OrderMapper;
import com.dedu.mall.feign.SkuFeignClient;
import com.dedu.mall.model.Result;
import com.dedu.mall.model.SkuVo;
import com.dedu.mall.model.mysql.OrderAllInfoPo;
import com.dedu.mall.model.mysql.OrderDetailPo;
import com.dedu.mall.model.mysql.OrderPo;
import com.dedu.mall.service.OrderService;
import com.dedu.mall.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderSerImpl extends ServiceImpl<OrderMapper, OrderPo> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SkuFeignClient skuFeignClient;

    @Override
    public IPage<OrderAllInfoPo> getOrderPage(Integer pageNum, Integer pageSize) {
        //分页查询
        List<OrderAllInfoPo> orderAllInfoPage = orderMapper.getOrderAllInfoPage(pageNum, pageSize);
        // 查询总数
        Integer orderAllInfoCount = orderMapper.getOrderAllInfoCount();
        // 返回值封装
        return convertOrderPoToVo(orderAllInfoCount, pageNum, pageSize, orderAllInfoPage);
    }

    private IPage<OrderAllInfoPo> convertOrderPoToVo(Integer pageTotal, Integer pageNum, Integer pageSize, List<OrderAllInfoPo> orderAllInfoPage) {
        IPage<OrderAllInfoPo> result = new Page<>(pageNum, pageSize);
        result.setTotal(pageTotal);
        result.setRecords(orderAllInfoPage);
        return result;
    }

    @Override
    public OrderDetailPo queryOrderDetailById(Long id) {
        OrderDetailPo result = orderMapper.getOrderDetailInfoById(id);
        if (null != result.getSkuId()) {
            Result<SkuVo> remoteRstData = skuFeignClient.getSkuById(result.getSkuId());
            SkuVo skuVo = ResultUtil.getResultData(remoteRstData);
            result.setSku(skuVo);
        }
        return result;
    }
}
