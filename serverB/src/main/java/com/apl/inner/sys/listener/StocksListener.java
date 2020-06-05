package com.apl.inner.sys.listener;

import com.apl.inner.sys.feign.AFeign;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StocksListener {

    @Autowired
    AFeign aFeign;

    @RabbitHandler
    @RabbitListener(queues = "serverBQueue")
    public void outOrderCreateStockUpdate(Message message, Channel channel) throws Exception {

        try {

            System.out.println("server b mq ---");
            aFeign.invokeBServer();

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
