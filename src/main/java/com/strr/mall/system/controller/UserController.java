package com.strr.mall.system.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.base.controller.CommonController;
import com.strr.mall.base.service.CommonService;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 * @author strr
 */
@RestController
@RequestMapping("/system/user")
public class UserController extends CommonController<User, Integer> {
    @Autowired
    private UserService userService;

    @Override
    protected CommonService<User, Integer> getService() {
        return userService;
    }

    /**
     * 保存用户
     * @param user
     * @param oldRids
     * @param newRids
     * @return
     */
    @PostMapping("/saveInfo")
    public CommonResult saveInfo(User user, Integer[] oldRids, Integer[] newRids) {
        CommonResult result = new CommonResult();
        try {
            userService.saveWithRids(user, oldRids, newRids);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取用户角色关系
     * @param uid
     * @return
     */
    @GetMapping("/listRelByUid")
    public CommonResult listRelByUid(Integer uid) {
        CommonResult result = new CommonResult();
        try {
            result.setData(userService.listRelByUid(uid));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
