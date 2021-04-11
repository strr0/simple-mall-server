package com.strr.mall.generator.util;

import com.strr.mall.common.Constant;
import com.strr.mall.generator.entity.ColumnInfo;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * 实体工具类
 */
public class ColumnUtil {
    /**
     * 实体信息mapper
     */
    private static RowMapper<ColumnInfo> columnInfoRowMapper = (rs, rowNum) -> {
        ColumnInfo columnInfo = new ColumnInfo();
        String columnName = rs.getString("COLUMN_NAME");
        columnInfo.setColumnName(columnName);
        columnInfo.setFieldName(getFieldName(columnName));
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

    /**
     * 获取实体信息
     * @param schema
     * @param table
     * @return
     */
    public static List<ColumnInfo> getColumnInfoList(String schema, String table) {
        String sql = MysqlUtil.getQuerySql(schema, table);
        return JdbcUtil.getMysqlJdbcTemplate().query(sql, columnInfoRowMapper);
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
