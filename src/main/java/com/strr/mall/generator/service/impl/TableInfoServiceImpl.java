package com.strr.mall.generator.service.impl;

import com.strr.mall.generator.dao.TableInfoDao;
import com.strr.mall.generator.entity.TableInfo;
import com.strr.mall.generator.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TableInfoServiceImpl implements TableInfoService {
    @Autowired
    private TableInfoDao tableInfoDao;

    @Override
    public List<TableInfo> getTableInfoList() {
        return tableInfoDao.getTableInfoList();
    }

    @Override
    public Map<String, Object> getTableInfoPage(Integer page, Integer size) {
        return tableInfoDao.getTableInfoPage(page, size);
    }
}
