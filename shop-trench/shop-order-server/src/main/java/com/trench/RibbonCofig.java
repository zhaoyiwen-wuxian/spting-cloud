package com.trench;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**自定义负载均衡代码式操作*/
@Configuration
public class RibbonCofig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
