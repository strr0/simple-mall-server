package com.strr.mall.common.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RbOrderReceiver {
    @RabbitListener(queues = "mall.order.cancel")
    public void handle(String message) {
        System.out.println("message: " + message);
    }
}
