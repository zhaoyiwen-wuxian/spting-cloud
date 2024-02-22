package com.trench;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RibbonCofigRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        //获得服务的实列
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        int nexted = ThreadLocalRandom.current().nextInt(allServers.size());
        Server server = allServers.get(nexted);
        if (server.isAlive()){
            return server;
        }else {
            this.choose(key);
        }
        return null;
    }
}
