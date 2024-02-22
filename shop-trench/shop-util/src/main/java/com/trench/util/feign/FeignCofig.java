package com.trench.util.feign;

import feign.Contract;
import feign.Request;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义fig in框架的全局返回日志
@Configuration
public class FeignCofig {

    @Bean
    public Logger.Level feginLogger(){
        return Logger.Level.ERROR;
    }

    /**修改契约为原生注解*/
   /* @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }*/

    //设置Feign的超时时间
    @Bean
    public Request.Options  options(){
        return new Request.Options(5000,10000);
    }


    /**设置自定义拦截器*/
    @Bean
    public FeignAuthInterceptor feignAuthInterceptor(){
        return new FeignAuthInterceptor();
    }
}
