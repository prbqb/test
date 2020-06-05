//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.apl.inner.sys.mq;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    private static final Logger log = LoggerFactory.getLogger(RabbitSender.class);
    @Autowired
    RabbitTemplate rabbitTemplate;

    final ConfirmCallback confirmCallback = new ConfirmCallback() {
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            RabbitSender.log.info("correlationData: " + correlationData);
            RabbitSender.log.info("ack: " + ack);
            if (!ack) {
                RabbitSender.log.info("异常处理....");
            }

        }
    };
    final ReturnCallback returnCallback = new ReturnCallback() {
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            RabbitSender.log.info("return exchange: {}, routingKey: {}, replyCode: {}, replyText: {}", new Object[]{exchange, routingKey, replyCode, replyText});
        }
    };

    public RabbitSender() {
    }

    public void send(String exchange, String routingKey, Object message) {
        this.rabbitTemplate.setConfirmCallback(this.confirmCallback);
        this.rabbitTemplate.setReturnCallback(this.returnCallback);
        String id = UUID.randomUUID().toString();
        log.info("id: {}", id);
        CorrelationData correlationData = new CorrelationData(id);
        this.rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
    }

    public void sendFanout(String exchange, Object message) {
        this.rabbitTemplate.setConfirmCallback(this.confirmCallback);
        this.rabbitTemplate.setReturnCallback(this.returnCallback);
        String id = UUID.randomUUID().toString();
        log.info("id: {}", id);
        CorrelationData correlationData = new CorrelationData(id);
        this.rabbitTemplate.convertAndSend(exchange, "", message, correlationData);
    }
}
