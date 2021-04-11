package com.strr.mall.generator.service.impl;

import com.strr.mall.generator.dao.ColumnInfoDao;
import com.strr.mall.generator.entity.ColumnInfo;
import com.strr.mall.generator.service.ColumnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnInfoServiceImpl implements ColumnInfoService {
    @Autowired
    private ColumnInfoDao columnInfoDao;

    @Override
    public List<ColumnInfo> getColumnInfoList(String schema, String table) {
        return columnInfoDao.getColumnInfoList(schema, table);
    }
}
