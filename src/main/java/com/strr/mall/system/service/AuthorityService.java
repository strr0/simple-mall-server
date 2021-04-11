package com.strr.mall.system.service;

import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Authority;

import java.util.List;

/**
 * 权限
 * @author strr
 */
public interface AuthorityService extends CommonService<Authority, Integer> {
    /**
     * 获取用户权限
     * @param uid
     * @return
     */
    List<Authority> listByUserId(Integer uid);

    /**
     * 所有菜单
     * @param authorityList
     * @return
     */
    List<Authority> getAllMenus(List<Authority> authorityList);

    /**
     * 菜单
     * @param authorityList
     * @return
     */
    List<Authority> getMenus(List<Authority> authorityList);

    /**
     * 按钮
     * @param authorityList
     * @return
     */
    List<Authority> getBtns(List<Authority> authorityList, Integer menuId);
}
