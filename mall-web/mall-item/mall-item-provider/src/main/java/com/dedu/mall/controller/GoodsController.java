package com.dedu.mall.controller;

import com.dedu.mall.model.Result;
import com.dedu.mall.model.ResultCode;
import com.dedu.mall.service.SpecificationGroupService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器
 */
@RestController()
@RequestMapping("/api/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private SpecificationGroupService specGroupService;

    @GetMapping("/group/category/{id}")
    @ApiOperation(value = "根据类目Id查询规则分组信息-dedu", notes = "规格")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "类目主键id", required = true)
    })
    public Result querySpecGroupByCategoryId(@PathVariable Long id) throws Exception {
        return Result.build(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), specGroupService.queryByCategoryId(id));
    }
}
