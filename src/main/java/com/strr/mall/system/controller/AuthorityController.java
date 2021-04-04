package com.strr.mall.system.controller;

import com.strr.mall.common.jpa.controller.CommonController;
import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Authority;
import com.strr.mall.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限
 * @author strr
 */
@RestController
@RequestMapping("/system/authority")
public class AuthorityController extends CommonController<Authority, Integer> {
    @Autowired
    private AuthorityService authorityService;

    @Override
    protected CommonService<Authority, Integer> getService() {
        return authorityService;
    }
}
