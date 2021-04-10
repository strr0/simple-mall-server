package com.strr.mall.system.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.jpa.controller.CommonController;
import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Authority;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 权限列表
     * @return
     */
    @Override
    public CommonResult list() {
        CommonResult result = new CommonResult();
        try {
            List<Authority> authorityList = authorityService.findAll();
            result.setData(authorityService.getAllMenus(authorityList));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取菜单
     * @param user
     * @return
     */
    @GetMapping("/getMenus")
    public CommonResult getMenus(@AuthenticationPrincipal User user) {
        CommonResult commonResult = new CommonResult();
        try {
            commonResult.setData(authorityService.getMenus(user.getAuthorityList()));
            commonResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setSuccess(false);
        }
        return commonResult;
    }

    /**
     * 获取按钮
     * @param user
     * @return
     */
    @GetMapping("/getBtns")
    public CommonResult getBtns(@AuthenticationPrincipal User user, Integer btnId) {
        CommonResult commonResult = new CommonResult();
        try {
            commonResult.setData(authorityService.getBtns(user.getAuthorityList(), btnId));
            commonResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setSuccess(false);
        }
        return commonResult;
    }
}
