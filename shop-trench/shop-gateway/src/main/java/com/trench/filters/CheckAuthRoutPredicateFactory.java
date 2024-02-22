package com.trench.filters;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

//自定义断言工厂
@Component
public class CheckAuthRoutPredicateFactory extends
        AbstractRoutePredicateFactory<CheckAuthRoutPredicateFactory.Config> {
    public CheckAuthRoutPredicateFactory(){
        super(Config.class);
    }

    @Override

    public Predicate<ServerWebExchange> apply(CheckAuthRoutPredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                if (config.getName().equals("trench")){
                    return true;
                }
                return false;
            }
        };
    }

    @Validated
    //接收参数
    public static class Config{
        private String name;

        public Config setName(String name) {
            this.name = name;
            return this;
        }

        public String getName(){
            return name;
        }
    }
}
