package com.apl.inner.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CY
 * @version 1.0.0
 * @ClassName InnerOrgApplication.java
 * @createTime 2019年07月22日 21:44:00  com.apl.org.sys
 */
@SpringBootApplication
@MapperScan("com.apl.inner.sys.mapper")
public class ServerB {

    public static void main(String[] args) {
        SpringApplication.run(ServerB.class, args);
    }


}
