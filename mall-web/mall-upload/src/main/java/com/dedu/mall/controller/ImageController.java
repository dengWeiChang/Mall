package com.dedu.mall.controller;

import com.dedu.mall.model.Result;
import com.dedu.mall.model.ResultCode;
import com.dedu.mall.service.UploadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api/upload")
public class ImageController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value="/image",headers="content-type=multipart/form-data")
    @ApiOperation(value = "上传图片到本地-dedu", notes = "上传")
    public Result uploadImage(@ApiParam(value="图片",required=true) @RequestParam("file")MultipartFile file) throws Exception {
        return Result.build(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), uploadService.uploadImage(file));
    }
}
