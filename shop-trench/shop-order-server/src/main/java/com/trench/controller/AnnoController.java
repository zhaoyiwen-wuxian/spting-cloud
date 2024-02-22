package com.trench.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AnnoController {
/**定义接口被降级和限流后的处理方法*/
    @RequestMapping("/annol")
    @SentinelResource(value = "annol",
    blockHandler = "annolBlockHandler",//被限流后调用的方法
    fallback = "annolFallback"//被降级后调用的方法
    )
    public String annol(String name){
        if ("wolfCode".equals(name)){
            throw new RuntimeException();
        }
        return name;
    }

    public String annolBlockHandler(String name, BlockException blockException){
        return "接口被限流了";
    }

    public String annolFallback(String name, Throwable throwable){
        return "接口发生了异常";
    }
}
