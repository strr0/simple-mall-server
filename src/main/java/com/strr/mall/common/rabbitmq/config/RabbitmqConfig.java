package com.strr.mall.common.rabbitmq.config;

import com.strr.mall.common.rabbitmq.constant.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    /**
     * 订单交换机
     * @return
     */
    @Bean
    DirectExchange orderExchange() {
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单交换机（延迟）
     * @return
     */
    @Bean
    DirectExchange orderExchangeTtl() {
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单队列
     * @return
     */
    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable(QueueEnum.QUEUE_ORDER_CANCEL.getName()).build();
    }

    /**
     * 订单队列（延迟）
     * @return
     */
    @Bean
    public Queue orderQueueTtl() {
        return QueueBuilder.durable(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())
                .build();
    }

    /**
     * 绑定
     * @return
     */
    @Bean
    Binding orderBinding() {
        return BindingBuilder.bind(orderQueue())
                .to(orderExchange())
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    @Bean
    Binding orderBindingTtl() {
        return BindingBuilder.bind(orderQueueTtl())
                .to(orderExchangeTtl())
                .with(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getRouteKey());
    }
}
