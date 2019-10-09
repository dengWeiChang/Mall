package com.dedu.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dedu.mall.model.mysql.OrderAllInfoPo;
import com.dedu.mall.model.mysql.OrderDetailPo;
import com.dedu.mall.model.mysql.OrderPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<OrderPo> {
    @Select("SELECT o.id as id,o.buyer_id as buyerId, o.total_price as totalPrice, o.title as title, o.create_time as createTime, o.update_time as updateTime, s.status as status, p.total_pay as totalPay, p.pay_type as payType FROM tb_order o LEFT JOIN tb_order_status s ON o.id = s.order_id LEFT JOIN tb_pay p ON o.id = p.order_id LIMIT #{pageNum}, #{pageSize}")
    List<OrderAllInfoPo> getOrderAllInfoPage(@Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    @Select("SELECT COUNT(*) FROM tb_order o LEFT JOIN tb_order_status s ON o.id = s.order_id LEFT JOIN tb_pay p ON o.id = p.order_id")
    Integer getOrderAllInfoCount();

    @Select("SELECT o.id as id,o.buyer_id as buyerId, o.total_price as totalPrice, o.title as title, o.create_time as createTime, o.update_time as updateTime, s.status as status, p.total_pay as totalPay, p.pay_type as payType FROM tb_order o LEFT JOIN tb_order_status s ON o.id = s.order_id LEFT JOIN tb_pay p ON o.id = p.order_id WHERE o.id = #{orderId}")
    OrderDetailPo getOrderDetailInfoById(@Param(value = "orderId") Long id);

}
