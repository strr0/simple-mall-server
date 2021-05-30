package com.strr.mall.common.redis.service;

public interface RedisService {
    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置过期时间
     * @param key
     * @param time
     * @return
     */
    boolean expire(String key, long timeout);

    /**
     * 删除数据
     * @param key
     */
    void delete(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    long increment(String key, long delta);
}
