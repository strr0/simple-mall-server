package com.strr.mall.common.rabbitmq.config;

import com.strr.mall.common.rabbitmq.constant.QueueEnum;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbOrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Integer orderId, long delayTimes) {
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getExchange(), QueueEnum.QUEUE_ORDER_CANCEL_TTL.getRouteKey(), orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
    }
}
