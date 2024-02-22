package com.trench.util;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

public class URLProduct {
    private static DiscoveryClient discoveryClient;

    public URLProduct(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public static String getURL(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("product-service").get(0);
       return "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
