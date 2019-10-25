package com.dedu.mall.service;

import com.dedu.mall.model.DeliveryAddress;

import java.util.List;

public interface UserService {
   List<DeliveryAddress> queryUserAddressByUsernamAndPassword(String username, String password);
}
