package com.strr.mall.generator.service;

import com.strr.mall.generator.entity.ColumnInfo;

import java.util.List;

public interface ColumnInfoService {
    List<ColumnInfo> getColumnInfoList(String schema, String table);
}
