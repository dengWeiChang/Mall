package com.dedu.mall.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JSONConfiguration {
    /**
     * Spring Boot中默认使用了Jackson做JSON的解析，对象中有null值时序列化会出SerializationFeature.FAIL_ON_EMPTY_BEANS问题
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                //Date 对象的格式
                .registerModule(new JavaTimeModule())
                //禁止序列化值为 null 的属性
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                //禁止序列化时间为时间戳
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
