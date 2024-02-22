package com.trench.fegin;

import com.trench.domain.Product;
import com.trench.impl.ProductFeignFallBack;
import com.trench.util.feign.FeignCofig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//远程调用名称  fallback配置容错发回类 feign框架和send使用  configuration日志级别返回
@FeignClient(name = "product-service",fallback = ProductFeignFallBack.class,configuration = FeignCofig.class)
public interface ProductFegin {

    @RequestMapping("/findById/{id}")  //feign原生注解为@RequestLine("GET /findById/{id}")
        // @PathVariable改为@Param
    Product findById(@PathVariable("id") Long id);
}
