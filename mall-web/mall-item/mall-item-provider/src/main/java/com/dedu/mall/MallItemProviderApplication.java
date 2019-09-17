package com.dedu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.dedu.mall.dao")
@SpringBootApplication
@EnableSwagger2
public class MallItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallItemProviderApplication.class, args);
    }

}
