package com.strr.mall.generator.entity;

import java.util.Date;

/**
 * 表信息
 * @author strr
 */
public class TableInfo {
    /**
     * 模式
     */
    private String tableSchema;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表类型
     */
    private String tableType;

    /**
     * 引擎
     */
    private String engine;

    /**
     * 版本
     */
    private String version;

    /**
     * 数据量
     */
    private Integer tableRows;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getTableRows() {
        return tableRows;
    }

    public void setTableRows(Integer tableRows) {
        this.tableRows = tableRows;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
