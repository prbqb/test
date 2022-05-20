package com.apl.inner.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CY
 * @version 1.0.0
 * @ClassName InnerOrgApplication.java
 * @createTime 2019年07月22日 21:44:00  com.apl.org.sys
 */
@SpringBootApplication(scanBasePackages = {"com.apl.inner.sys"})
@EnableEurekaClient
@EnableFeignClients
public class ServerB {

    public static void main(String[] args) {
        List<Map> list = new ArrayList<>();
        System.out.println("i am user2");
        SpringApplication.run(ServerB.class, args);
        System.out.println("i am new doing ");
        System.out.println("commit file ");
        System.out.println("i am user2");
    }


}
