package com.strr.mall.system.service;

import com.strr.mall.base.service.CommonService;
import com.strr.mall.system.entity.User;

import java.util.List;

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

    /**
     * 保存用户
     * @param user
     * @param oldRids
     * @param newRids
     */
    void saveWithRids(User user, Integer[] oldRids, Integer[] newRids);

    /**
     * 获取用户角色关系
     * @param uid
     * @return
     */
    List<Integer> listRelByUid(Integer uid);
}
