package com.strr.mall.common.rabbitmq.constant;

public enum QueueEnum {
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    QUEUE_ORDER_CANCEL_TTL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    private String exchange;
    private String name;
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
