package com.strr.mall.system.dao;

import com.strr.mall.system.entity.Authority;

import java.util.List;

/**
 * 权限
 * @author strr
 */
public interface AuthorityDao {
    /**
     * 获取用户权限
     * @param uid
     * @return
     */
    List<Authority> listByUserId(Integer uid);
}
