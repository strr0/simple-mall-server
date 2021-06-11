package com.strr.mall.system.service.impl;

import com.strr.mall.base.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.Role;
import com.strr.mall.system.repository.RoleRepository;
import com.strr.mall.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色
 * @author strr
 */
@Service
public class RoleServiceImpl extends CommonServiceImpl<Role, Integer> implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, Integer> getJpaRepository() {
        return roleRepository;
    }

    /**
     * 保存角色权限关系
     * @param rid
     * @param aids
     */
    @Override
    public void updateRel(Integer rid, Integer[] oldAids, Integer[] newAids) {
        List<Integer> oldAidList = oldAids != null ? Arrays.asList(oldAids) : new ArrayList<>();
        List<Integer> newAidList = newAids != null ? Arrays.asList(newAids) : new ArrayList<>();
        // 删除权限
        List<Integer> removeAids = new ArrayList<>();
        removeAids.addAll(oldAidList);
        removeAids.removeAll(newAidList);
        roleRepository.deleteRel(rid, removeAids);
        // 添加权限
        List<Integer> addAids = new ArrayList<>();
        addAids.addAll(newAidList);
        addAids.removeAll(oldAidList);
        roleRepository.saveRel(rid, addAids);
    }

    /**
     * 获取角色权限关系
     * @param rid
     * @return
     */
    @Override
    public List<Integer> listRelByRid(Integer rid) {
        return roleRepository.listRelByRid(rid);
    }
}
