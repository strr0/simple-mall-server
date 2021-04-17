package com.strr.mall.generator.dao.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.generator.dao.ColumnInfoDao;
import com.strr.mall.generator.entity.ColumnInfo;
import com.strr.mall.generator.util.MysqlUtil;
import com.strr.mall.generator.util.ColumnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColumnInfoDaoImpl implements ColumnInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 实体信息mapper
     */
    private RowMapper<ColumnInfo> columnInfoRowMapper = (rs, rowNum) -> {
        ColumnInfo columnInfo = new ColumnInfo();
        String columnName = rs.getString("COLUMN_NAME");
        columnInfo.setColumnName(columnName);
        columnInfo.setFieldName(ColumnUtil.getFieldName(columnName));
        String dataType = rs.getString("DATA_TYPE");
        columnInfo.setDataType(dataType);
        columnInfo.setFieldType(MysqlUtil.DATA_TYPE.getNameByIndex(dataType));
        columnInfo.setColumnComment(rs.getString("COLUMN_COMMENT"));
        String columnKey = rs.getString("COLUMN_KEY");
        if (Constant.PRI_KEY.equals(columnKey)) {
            columnInfo.setIsKey(true);
        } else {
            columnInfo.setIsKey(false);
        }
        return columnInfo;
    };

    @Override
    public List<ColumnInfo> getColumnInfoList(String schema, String table) {
        String sql = "select COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY from INFORMATION_SCHEMA.COLUMNS " +
                "where TABLE_SCHEMA = ? and TABLE_NAME = ? order by ORDINAL_POSITION";
        return jdbcTemplate.query(sql, new Object[] {schema, table}, columnInfoRowMapper);
    }
}
