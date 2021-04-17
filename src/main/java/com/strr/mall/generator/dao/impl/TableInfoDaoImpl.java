package com.strr.mall.generator.dao.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.generator.dao.TableInfoDao;
import com.strr.mall.generator.entity.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TableInfoDaoImpl implements TableInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<TableInfo> tableInfoRowMapper = (rs, rowNum) -> {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableSchema(rs.getString("TABLE_SCHEMA"));
        tableInfo.setTableName(rs.getString("TABLE_NAME"));
        tableInfo.setTableType(rs.getString("TABLE_TYPE"));
        tableInfo.setEngine(rs.getString("ENGINE"));
        tableInfo.setVersion(rs.getString("VERSION"));
        tableInfo.setTableRows(rs.getInt("TABLE_ROWS"));
        tableInfo.setCreateTime(rs.getTime("CREATE_TIME"));
        tableInfo.setUpdateTime(rs.getTime("UPDATE_TIME"));
        return tableInfo;
    };

    @Override
    public List<TableInfo> getTableInfoList() {
        String sql = "select TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE, VERSION, TABLE_ROWS, CREATE_TIME, UPDATE_TIME " +
                "from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = ?";
        return jdbcTemplate.query(sql, new Object[] {Constant.TABLE_SCHEMA}, tableInfoRowMapper);
    }

    @Override
    public Map<String, Object> getTableInfoPage(Integer page, Integer size) {
        Map<String, Object> map = new HashMap<>();
        String countSql = "select count(1) from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = ?";
        Integer total = jdbcTemplate.queryForObject(countSql, new Object[] {Constant.TABLE_SCHEMA}, Integer.class);
        String querySql = "select TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE, VERSION, TABLE_ROWS, CREATE_TIME, UPDATE_TIME " +
                "from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = ? limit ?, ?";
        List<TableInfo> content = jdbcTemplate.query(querySql, new Object[] {Constant.TABLE_SCHEMA, page, size}, tableInfoRowMapper);
        map.put("total", total);
        map.put("content", content);
        return map;
    }
}
