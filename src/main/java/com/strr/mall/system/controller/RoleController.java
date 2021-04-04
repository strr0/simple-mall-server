package com.strr.mall.system.controller;

import com.strr.mall.common.jpa.controller.CommonController;
import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Role;
import com.strr.mall.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色
 * @author strr
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends CommonController<Role, Integer> {
    @Autowired
    private RoleService roleService;

    @Override
    protected CommonService<Role, Integer> getService() {
        return roleService;
    }
}
