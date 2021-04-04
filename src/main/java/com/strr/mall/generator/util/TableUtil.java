package com.strr.mall.generator.util;

import com.strr.mall.generator.entity.TableInfo;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * 实体工具类
 */
public class TableUtil {
    /**
     * 实体信息mapper
     */
    private static RowMapper<TableInfo> tableInfoRowMapper = (rs, rowNum) -> {
        TableInfo tableInfo = new TableInfo();
        String columnName = rs.getString("COLUMN_NAME");
        tableInfo.setColumnName(columnName);
        tableInfo.setFieldName(getFieldName(columnName));
        String dataType = rs.getString("DATA_TYPE");
        tableInfo.setDataType(dataType);
        tableInfo.setFieldType(MysqlUtil.DATA_TYPE.getNameByIndex(dataType));
        tableInfo.setColumnComment(rs.getString("COLUMN_COMMENT"));
        return tableInfo;
    };

    /**
     * 获取实体信息
     * @param schema
     * @param table
     * @return
     */
    public static List<TableInfo> getTableInfoList(String schema, String table) {
        String sql = MysqlUtil.getQuerySql(schema, table);
        return JdbcUtil.getMysqlJdbcTemplate().query(sql, tableInfoRowMapper);
    }

    /**
     * 获取实体字段名称
     * @param columnName
     * @return
     */
    public static String getFieldName(String columnName) {
        String[] names = columnName.split("_");
        if (names.length > 1) {
            StringBuilder builder = new StringBuilder();
            builder.append(names[0].toLowerCase());
            for (int i = 1; i < names.length; i++) {
                String name = names[i];
                builder.append(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
            }
            return builder.toString();
        }
        return columnName.toLowerCase();
    }
}
