package com.trench.impl;

import com.trench.domain.Product;
import com.trench.fegin.ProductFegin;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallBack implements ProductFegin {
    @Override
    public Product findById(Long id) {
        return Product.builder()
                .price(0.0)
                .stock(0)
                .name("容错")
                .build();
    }
}
