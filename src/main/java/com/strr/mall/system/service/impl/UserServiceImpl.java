package com.strr.mall.system.service.impl;

import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.repository.UserRepository;
import com.strr.mall.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 用户
 * @author strr
 */
@Service
public class UserServiceImpl extends CommonServiceImpl<User, Integer> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected JpaRepository<User, Integer> getJpaRepository() {
        return userRepository;
    }

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
