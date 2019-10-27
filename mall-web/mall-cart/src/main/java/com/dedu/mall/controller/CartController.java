package com.dedu.mall.controller;

import com.dedu.mall.model.Result;
import com.dedu.mall.model.ResultCode;
import com.dedu.mall.service.CartService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    @ApiOperation(value = "根据用户Id查询购物车列表-dedu", notes = "购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "userId", value = "用户主键id", required = true)
    })
    public Result queryUserShopCartByUserId(@PathVariable Long userId) throws Exception {
        return Result.build(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), cartService.queryUserShopCartByUserId(userId));
    }
}
