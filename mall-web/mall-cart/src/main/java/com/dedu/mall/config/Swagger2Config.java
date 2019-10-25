package com.dedu.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dedu.mall.controller"))
                .paths(PathSelectors.any())
                .build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("德都-商城系统-API文档")
				.description("商城商品信息接口")
				.version("0.0.1-snapshot")
				.build();
	}

}