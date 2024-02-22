package com.trench.domain;

import com.trench.util.domain.util.ObjectDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "t_shop_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends ObjectDomain implements Serializable {
    private static final long serialVersionUID = -703247956798735422L;

    private String name;

    /**价格*/
    private Double price;

    /**库存*/
    private Integer stock;
}
