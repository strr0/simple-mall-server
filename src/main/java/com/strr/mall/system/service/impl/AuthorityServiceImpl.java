package com.strr.mall.system.service.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.Authority;
import com.strr.mall.system.repository.AuthorityRepository;
import com.strr.mall.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限
 * @author strr
 */
@Service
public class AuthorityServiceImpl extends CommonServiceImpl<Authority, Integer> implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    protected JpaRepository<Authority, Integer> getJpaRepository() {
        return authorityRepository;
    }

    /**
     * 获取用户权限
     * @param uid
     * @return
     */
    @Override
    public List<Authority> listByUserId(Integer uid) {
        return authorityRepository.listByUserId(uid);
    }

    @Override
    public List<Authority> getAllMenus(List<Authority> authorityList) {
        List<Authority> menus = new ArrayList<>();
        for (Authority authority : authorityList) {
            if (Constant.MENU_ROOT_ID.equals(authority.getParentId())) {
                Authority menu = new Authority(authority);
                menu.setChildren(getMenuItems(menu.getId(), authorityList));
                menus.add(menu);
            }
        }
        return menus;
    }

    /**
     * 菜单
     * @param authorityList
     * @return
     */
    @Override
    public List<Authority> getMenus(List<Authority> authorityList) {
        List<Authority> menus = new ArrayList<>();
        for (Authority authority : authorityList) {
            if (authority.getIsMenu()) {
                menus.add(new Authority(authority));
            }
        }
        return getAllMenus(menus);
    }

    /**
     * 递归获取子菜单
     * @param id
     * @param authorityList
     * @return
     */
    private List<Authority> getMenuItems(Integer id, List<Authority> authorityList) {
        List<Authority> menuItems = new ArrayList<>();
        for (Authority authority : authorityList) {
            if (id.equals(authority.getParentId())) {
                Authority menuItem = new Authority(authority);
                menuItem.setChildren(getMenuItems(menuItem.getId(), authorityList));
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }

    /**
     * 按钮
     * @param authorityList
     * @return
     */
    @Override
    public List<Authority> getBtns(List<Authority> authorityList, Integer menuId) {
        List<Authority> btns = new ArrayList<>();
        for (Authority authority : authorityList) {
            if (authority.getParentId().equals(menuId) && !authority.getIsMenu()) {
                btns.add(new Authority(authority));
            }
        }
        return btns;
    }
}
