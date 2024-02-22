package com.trench.filters;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
/**接口请求耗时全局*/
public class TimeGatewayFiltersFactory extends
        AbstractGatewayFilterFactory<TimeGatewayFiltersFactory.Config> {


    public TimeGatewayFiltersFactory(){
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("show");
    }

    @Override
    public GatewayFilter apply(TimeGatewayFiltersFactory.Config config) {
        return new GatewayFilter() {
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                long start = System.currentTimeMillis();
                if (!config.isShow()){
                   return chain.filter(exchange).then(Mono.fromRunnable(()->{
                                //添加自己想要进行存储的逻辑。可以存储数据库red is/es等中
                                log.info("请求耗时：{}",System.currentTimeMillis()-start);
                            }
                    ));
                }else {
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
                    return exchange.getResponse().setComplete().then(Mono.fromRunnable(()->{
                                //添加自己想要进行存储的逻辑。可以存储数据库red is/es等中
                                log.info("请求耗时：{}",System.currentTimeMillis()-start);
                            }
                    ));
                }
            }
        };
    }

    @Getter
    @Setter
    public static class Config {
        private boolean show;
    }
}

