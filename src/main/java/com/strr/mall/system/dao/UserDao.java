package com.strr.mall.system.dao;

import java.util.List;

/**
 * 用户
 * @author strr
 */
public interface UserDao {
    /**
     * 获取用户角色关系
     * @param uid
     * @return
     */
    List<Integer> listRelByUid(Integer uid);

    /**
     * 保存用户角色关系
     * @param uid
     * @param rids
     */
    void saveRel(Integer uid, List<Integer> rids);

    /**
     * 删除用户角色关系
     * @param uid
     * @param rids
     */
    void deleteRel(Integer uid, List<Integer> rids);
}
