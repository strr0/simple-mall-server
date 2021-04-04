package com.strr.mall.generator.util;

/**
 * Mysql工具类
 */
public class MysqlUtil {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/simple_mall?serverTimezone=UTC";
    public static String USERNAME = "root";
    public static String PASSWORD = "password";

    /**
     * MySQL数据类型
     */
    public enum DATA_TYPE {
        INT("int", "Integer"),
        DOUBLE("double", "Double"),
        STRING("string", "String"),
        DATE("date", "Date"),
        TIMESTAMP("timestamp", "Date"),
        TINYINT("tinyint", "Integer"),
        DATETIME("datetime", "Date");

        private String index;
        private String name;

        private DATA_TYPE(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getNameByIndex(String idx) {
            for (DATA_TYPE type : DATA_TYPE.values()) {
                if (type.getIndex().equals(idx)) {
                    return type.getName();
                }
            }
            return STRING.getName();
        }
    }

    /**
     * 查询表信息sql
     * @param schema
     * @param table
     * @return
     */
    public static String getQuerySql(String schema, String table) {
        return "select COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT from INFORMATION_SCHEMA.COLUMNS where table_schema = '" + schema + "' " +
                "and table_name = '" + table + "' order by ORDINAL_POSITION";
    }
}
