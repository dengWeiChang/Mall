package com.dedu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dedu.mall.dao")
@SpringBootApplication
public class MallItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallItemProviderApplication.class, args);
    }

}
