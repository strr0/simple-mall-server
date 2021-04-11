package com.strr.mall.generator.dao.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.generator.dao.TableInfoDao;
import com.strr.mall.generator.entity.TableInfo;
import com.strr.mall.generator.util.MysqlUtil;
import com.strr.mall.generator.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableInfoDaoImpl implements TableInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 实体信息mapper
     */
    private RowMapper<TableInfo> tableInfoRowMapper = (rs, rowNum) -> {
        TableInfo tableInfo = new TableInfo();
        String columnName = rs.getString("COLUMN_NAME");
        tableInfo.setColumnName(columnName);
        tableInfo.setFieldName(TableUtil.getFieldName(columnName));
        String dataType = rs.getString("DATA_TYPE");
        tableInfo.setDataType(dataType);
        tableInfo.setFieldType(MysqlUtil.DATA_TYPE.getNameByIndex(dataType));
        tableInfo.setColumnComment(rs.getString("COLUMN_COMMENT"));
        String columnKey = rs.getString("COLUMN_KEY");
        if (Constant.PRI_KEY.equals(columnKey)) {
            tableInfo.setIsKey(true);
        } else {
            tableInfo.setIsKey(false);
        }
        return tableInfo;
    };

    @Override
    public List<TableInfo> getTableInfoList(String schema, String table) {
        String sql = "select COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY from INFORMATION_SCHEMA.COLUMNS " +
                "where table_schema = ? and table_name = ? order by ORDINAL_POSITION";
        return jdbcTemplate.query(sql, new Object[] {schema, table}, tableInfoRowMapper);
    }
}
