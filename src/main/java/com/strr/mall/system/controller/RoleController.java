package com.strr.mall.system.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.base.controller.CommonController;
import com.strr.mall.base.service.CommonService;
import com.strr.mall.system.entity.Role;
import com.strr.mall.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 获取角色权限关系
     * @param rid
     * @return
     */
    @GetMapping("/listRelByRid")
    public CommonResult listRelByRid(Integer rid) {
        CommonResult result = new CommonResult();
        try {
            result.setData(roleService.listRelByRid(rid));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 更新角色权限
     * @param rid
     * @param oldAids
     * @param newAids
     * @return
     */
    @PostMapping("/updateRel")
    public CommonResult updateRel(Integer rid, Integer[] oldAids, Integer[] newAids) {
        CommonResult result = new CommonResult();
        try {
            roleService.updateRel(rid, oldAids, newAids);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
