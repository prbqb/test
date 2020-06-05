package com.apl.inner.sys.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BasicDbMqConfig {

    @Bean
    public Queue serverBQueue(){

        //url : https://blog.csdn.net/u013871100/article/details/82982235
        Map<String, Object> args = new HashMap<>();
        return new Queue("serverBQueue",true,false,false,args);
    }


    @Bean
    public FanoutExchange serverBExchange(){

        return new FanoutExchange("serverBExchange");
    }


    @Bean
    public Binding serverBBinding(Queue serverBQueue, FanoutExchange serverBExchange){

        return BindingBuilder.bind(serverBQueue).to(serverBExchange);
    }




}
