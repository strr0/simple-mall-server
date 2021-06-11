package com.strr.mall.common.rabbitmq.service;

public interface RbOrderService {
    boolean createOrder(Integer orderId);
    boolean cancelOrder(Integer orderId);
}
