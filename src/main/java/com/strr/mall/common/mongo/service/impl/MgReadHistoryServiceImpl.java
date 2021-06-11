package com.strr.mall.common.mongo.service.impl;

import com.strr.mall.common.mongo.entity.MgReadHistory;
import com.strr.mall.common.mongo.repository.MgReadHistoryRepository;
import com.strr.mall.common.mongo.service.MgReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MgReadHistoryServiceImpl implements MgReadHistoryService {
    @Autowired
    private MgReadHistoryRepository mgReadHistoryRepository;

    @Override
    public void save(MgReadHistory mgReadHistory) {
        mgReadHistoryRepository.save(mgReadHistory);
    }

    @Override
    public void deleteById(Integer id) {
        mgReadHistoryRepository.deleteById(id);
    }

    @Override
    public List<MgReadHistory> findByUserId(Integer userId) {
        return mgReadHistoryRepository.findByUserIdOrderByCreateTimeDesc(userId);
    }
}
