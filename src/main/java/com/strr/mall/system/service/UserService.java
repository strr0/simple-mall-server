package com.strr.mall.system.service;

import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.User;

/**
 * 用户
 * @author strr
 */
public interface UserService extends CommonService<User, Integer> {
    /**
     * 获取用户
     * @param username
     * @return
     */
    User getByUsername(String username);
}
