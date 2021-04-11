package com.strr.mall.generator.dao;

import com.strr.mall.generator.entity.TableInfo;

import java.util.List;

public interface TableInfoDao {
    List<TableInfo> getTableInfoList(String schema, String table);
}
