package com.trench.impl;

import com.trench.dao.OrderDao;
import com.trench.domain.Order;
import com.trench.domain.Product;
import com.trench.fegin.ProductFegin;
import com.trench.server.OrderServer;
import com.trench.util.URLProduct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderServerImpl implements OrderServer {

    @Resource
    private OrderDao orderDao;

    @Resource
    private ProductFegin productFegin;
    @Resource
    private RestTemplate restTemplate;
    @Override
    public Order save(Long productId, Long userId) {
        Order order=new Order();
        //通过nacos获取
        //String url= URLProduct.getURL()+"/product/findById"+productId;
        //通过负载均衡获取
        /*String url="http://product-service/product/findById"+productId;
        Product product=restTemplate.getForObject(url,Product.class);*/
        //第三种fegion框架
        Product product=productFegin.findById(productId);
        orderDao.save(order);
        return order;
    }
}
