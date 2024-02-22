package com.trench.util;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TraceServer {
    @SentinelResource(value = "traceServer")
    public void traceServer(){
        throw new RuntimeException("调用traceServer方法限流了");
    }
}
