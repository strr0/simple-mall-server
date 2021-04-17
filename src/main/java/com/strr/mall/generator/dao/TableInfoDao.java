package com.strr.mall.generator.dao;

import com.strr.mall.generator.entity.TableInfo;

import java.util.List;
import java.util.Map;

public interface TableInfoDao {
    /**
     * 表信息列表
     * @return
     */
    List<TableInfo> getTableInfoList();

    /**
     * 表信息分页
     * @param page
     * @param size
     * @return
     */
    Map<String, Object> getTableInfoPage(Integer page, Integer size);
}
