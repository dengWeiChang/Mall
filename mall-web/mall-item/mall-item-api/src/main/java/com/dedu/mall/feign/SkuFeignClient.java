package com.dedu.mall.feign;

import com.dedu.mall.fallback.SkuFeignClientFallBack;
import com.dedu.mall.model.Result;
import com.dedu.mall.model.SkuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "mall-item-provider",
        fallback = SkuFeignClientFallBack.class
)
public interface SkuFeignClient {

    @GetMapping("/api/sku/{id}")
    Result<SkuVo> getSkuById(@PathVariable Long id);
}
