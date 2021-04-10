package com.strr.mall.system.service;

import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Role;

import java.util.List;

/**
 * 角色
 * @author strr
 */
public interface RoleService extends CommonService<Role, Integer> {
    /**
     * 保存角色权限关系
     * @param rid
     * @param aids
     */
    void updateRel(Integer rid, Integer[] oldAids, Integer[] newAids);

    /**
     * 获取角色权限关系
     * @param rid
     * @return
     */
    List<Integer> listRelByRid(Integer rid);
}
