package com.strr.mall.generator.service.impl;

import com.strr.mall.generator.dao.TableInfoDao;
import com.strr.mall.generator.entity.TableInfo;
import com.strr.mall.generator.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableInfoServiceImpl implements TableInfoService {
    @Autowired
    private TableInfoDao tableInfoDao;

    @Override
    public List<TableInfo> getTableInfoList(String schema, String table) {
        return tableInfoDao.getTableInfoList(schema, table);
    }
}
