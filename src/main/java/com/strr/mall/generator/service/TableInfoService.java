package com.strr.mall.generator.service;

import com.strr.mall.generator.entity.TableInfo;

import java.util.List;

public interface TableInfoService {
    List<TableInfo> getTableInfoList(String schema, String table);
}
