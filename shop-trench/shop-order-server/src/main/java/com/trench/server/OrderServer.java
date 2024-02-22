package com.trench.server;

import com.trench.domain.Order;

public interface OrderServer {
    Order save(Long productId, Long userId);
}
