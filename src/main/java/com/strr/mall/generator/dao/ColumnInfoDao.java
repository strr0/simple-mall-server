package com.strr.mall.generator.dao;

import com.strr.mall.generator.entity.ColumnInfo;

import java.util.List;

public interface ColumnInfoDao {
    List<ColumnInfo> getColumnInfoList(String schema, String table);
}
