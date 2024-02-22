package com.trench.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**自定义限流设置修改默认的*/
@Configuration
public class GatewayConfiguration {

    @PostConstruct
    public void init(){
        initCustomsApis();

        initGatewayRules();
        initBlackHandlers();

    }

    //自定义限流异常处理
    private void initBlackHandlers(){
        BlockRequestHandler blockExceptionHandler=new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
                //可以通过throwable来判断各种异常

                Map map=new HashMap<>();
                map.put("code",0);
                map.put("message","接口被限流");
                return ServerResponse.status(HttpStatus.OK).
                        contentType(MediaType.APPLICATION_JSON).
                        body(BodyInserters.fromValue(map));
            }
        };
        GatewayCallbackManager.setBlockHandler(blockExceptionHandler);
    }

    //加载网关规则
    private void initGatewayRules(){
        Set<GatewayFlowRule> rules=new HashSet<>();
        rules.add(new GatewayFlowRule("order-server")
                .setCount(2)
                .setIntervalSec(1)
        );
        //......
        GatewayRuleManager.loadRules(rules);
    }
    //初始化自定义api
    private void initCustomsApis(){
        Set<ApiDefinition> definitions=new HashSet<>();
        ApiDefinition api = new ApiDefinition("order-server")
                .setPredicateItems(new HashSet<ApiPredicateItem>(){
                    {
                        add(new ApiPathPredicateItem().setPattern("/order/**")
                                .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX)
                        );
                    }});
        definitions.add(api);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }
}
