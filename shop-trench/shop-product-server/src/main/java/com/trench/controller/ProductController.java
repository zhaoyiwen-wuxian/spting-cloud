package com.trench.controller;

import com.trench.domain.Product;
import com.trench.server.product.ProductServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController(value = "/product")
public class ProductController {
    public static Logger log= LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductServer productServer;

    @RequestMapping(value = "/findById/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productServer.findById(id);
    }
}
