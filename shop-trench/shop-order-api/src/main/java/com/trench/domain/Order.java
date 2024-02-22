package com.trench.domain;

import com.trench.util.domain.util.ObjectDomain;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "t_shop_order")
@Data
public class Order extends ObjectDomain implements Serializable {
    private static final long serialVersionUID = -703247956798735422L;

    //用户ID
    private Long uid;

    /**用户名*/
    private String userName;

    //商品ID
    private Long productId;

    //商品名称
    private String productName;

    //单价
    private Double price;

    /**购买数量*/
    private Integer number;
}
