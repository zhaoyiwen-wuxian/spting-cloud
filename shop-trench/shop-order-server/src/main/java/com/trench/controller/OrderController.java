package com.trench.controller;

import com.trench.domain.Order;
import com.trench.server.OrderServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "order")
public class OrderController {
    public static Logger log= LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderServer orderServer;

    @RequestMapping(value = "save")
    public Order save(Long productId, Long userId){
        return orderServer.save(productId, userId);
    }
}
