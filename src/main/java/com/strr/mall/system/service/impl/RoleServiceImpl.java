package com.strr.mall.system.service.impl;

import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.Role;
import com.strr.mall.system.repository.RoleRepository;
import com.strr.mall.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
}
