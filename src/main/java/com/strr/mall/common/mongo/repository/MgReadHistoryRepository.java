package com.strr.mall.common.mongo.repository;

import com.strr.mall.common.mongo.entity.MgReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MgReadHistoryRepository extends MongoRepository<MgReadHistory, Integer> {
    List<MgReadHistory> findByUserIdOrderByCreateTimeDesc(Integer userId);
}
