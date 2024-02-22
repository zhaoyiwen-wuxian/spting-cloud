package com.trench.impl.product;

import com.trench.dao.product.ProductDao;
import com.trench.domain.Product;
import com.trench.server.product.ProductServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServerImpl implements ProductServer {

    @Resource
    private ProductDao productDao;
    @Override
    public Product findById(Long id) {
        return productDao.findById(id).get();
    }
}
