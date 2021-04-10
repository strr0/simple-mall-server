package com.strr.mall.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 权限
 * @author strr
 */
@Entity
@Table(name = "sys_authority")
public class Authority {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 路由
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 组件
     */
    private String component;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父菜单
     */
    private Integer parentId;

    /**
     * 是否为菜单
     */
    private Boolean isMenu;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 子菜单
     */
    private List<Authority> children;

    public Authority() {}

    public Authority(Authority authority) {
        id = authority.id;
        url = authority.url;
        path = authority.path;
        name = authority.name;
        component = authority.component;
        icon = authority.icon;
        parentId = authority.parentId;
        isMenu = authority.isMenu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Column(name = "is_menu")
    public Boolean getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Boolean isMenu) {
        this.isMenu = isMenu;
    }

    @Column(name = "creator")
    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "updator")
    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Transient
    public List<Authority> getChildren() {
        return children;
    }

    public void setChildren(List<Authority> children) {
        this.children = children;
    }
}
