package com.strr.mall.common.rabbitmq.service.impl;

import com.strr.mall.common.rabbitmq.config.RbOrderSender;
import com.strr.mall.common.rabbitmq.service.RbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RbOrderServiceImpl implements RbOrderService {
    @Autowired
    private RbOrderSender rbOrderSender;

    @Override
    public boolean createOrder(Integer orderId) {
        try {
            rbOrderSender.sendMessage(orderId, 30 * 1000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean cancelOrder(Integer orderId) {
        // TODO: 2021/6/10
        return true;
    }
}
