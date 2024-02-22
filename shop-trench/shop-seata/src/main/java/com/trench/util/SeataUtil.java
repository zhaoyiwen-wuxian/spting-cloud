package com.trench.util;

import io.seata.spring.annotation.GlobalTransactional;

public class SeataUtil {

    //分布式事物，并且此类事物主要使用调用需要使用的三方server方法。
    //注解使用：@GlobalTransactional作为分布式锁
}
