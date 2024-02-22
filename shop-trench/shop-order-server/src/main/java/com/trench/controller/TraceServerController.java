package com.trench.controller;

import com.trench.util.TraceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TraceServerController {
    @Resource
    private TraceServer traceServer;


    @RequestMapping("trace")
    public String trace(){
        traceServer.traceServer();
        return "trace";
    }
}
