package com.strr.mall.common.rabbitmq.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.rabbitmq.service.RbOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "RbOrderController", description = "订单管理")
@RestController
@RequestMapping("/rb/order")
public class RbOrderController {
    @Autowired
    private RbOrderService rbOrderService;

    @GetMapping("/createOrder")
    public CommonResult createOrder(Integer orderId) {
        if (rbOrderService.createOrder(orderId)) {
            return CommonResult.SUCCESS;
        }
        return CommonResult.FAILURE;
    }
}
