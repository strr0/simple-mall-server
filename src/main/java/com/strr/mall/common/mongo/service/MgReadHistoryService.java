package com.strr.mall.common.mongo.service;

import com.strr.mall.common.mongo.entity.MgReadHistory;

import java.util.List;

public interface MgReadHistoryService {
    void save(MgReadHistory mgReadHistory);
    void deleteById(Integer id);
    List<MgReadHistory> findByUserId(Integer userId);
}
