package com.dedu.mall.controller;

import com.dedu.mall.model.mysql.CategoryVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/category")
@CrossOrigin
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "SUCCESS";
    }

    @GetMapping("")
    public List<CategoryVo> helloMP() {
        List<CategoryVo> result = new ArrayList<>();
        CategoryVo one = CategoryVo.builder().id(1L).isParent(true).name("onetest").build();
        one.setChildren(new ArrayList<>());
        CategoryVo two = CategoryVo.builder().name("twotest").build();
        two.setChildren(new ArrayList<>());
        result.add(one);
        result.add(two);
        return result;
    }
}
