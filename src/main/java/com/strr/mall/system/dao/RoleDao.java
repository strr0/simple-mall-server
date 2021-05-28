package com.strr.mall.system.dao;

import java.util.List;

/**
 * 角色
 * @author strr
 */
public interface RoleDao {
    /**
     * 获取角色权限关系
     * @param rid
     * @return
     */
    List<Integer> listRelByRid(Integer rid);

    /**
     * 保存角色权限关系
     * @param rid
     * @param aids
     */
    void saveRel(Integer rid, List<Integer> aids);

    /**
     * 删除角色权限关系
     * @param rid
     * @param aids
     */
    void deleteRel(Integer rid, List<Integer> aids);
}
