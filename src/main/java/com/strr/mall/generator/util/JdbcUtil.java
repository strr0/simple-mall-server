package com.strr.mall.generator.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcUtil {
    /**
     * 获取jdbcTemplate
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static JdbcTemplate getMysqlJdbcTemplate() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(MysqlUtil.DRIVER);
        dataSource.setUrl(MysqlUtil.URL);
        dataSource.setUsername(MysqlUtil.USERNAME);
        dataSource.setPassword(MysqlUtil.PASSWORD);
        return new JdbcTemplate(dataSource);
    }
}
