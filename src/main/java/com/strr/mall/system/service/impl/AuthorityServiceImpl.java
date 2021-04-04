package com.strr.mall.system.service.impl;

import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.Authority;
import com.strr.mall.system.repository.AuthorityRepository;
import com.strr.mall.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
}
