package com.trench.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//需要动态更新nacos中的值
public class TestController {
    @Value("$(appConfig.name)")
    private String appConfigName;


}
