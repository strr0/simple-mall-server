package com.strr.mall.system.controller;

import com.strr.mall.common.jpa.controller.CommonController;
import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
