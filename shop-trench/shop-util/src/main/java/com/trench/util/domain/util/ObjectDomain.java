package com.trench.util.domain.util;

import com.trench.util.snow.SnowFlakeFactory;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class ObjectDomain implements Serializable {
    private static final long serialVersionUID = -7032479567987350259L;

    /**
     * 数据id
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ObjectDomain(){
        this.id= SnowFlakeFactory.getSnowFlake().nextId();
    }

}
