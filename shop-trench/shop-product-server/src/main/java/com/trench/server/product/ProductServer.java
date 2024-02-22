package com.trench.server.product;

import com.trench.domain.Product;

import java.util.List;

public interface ProductServer {

    Product findById(Long id);
}
