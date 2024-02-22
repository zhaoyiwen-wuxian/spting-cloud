package com.trench.dao.product;

import com.trench.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Product,Long> {
}
