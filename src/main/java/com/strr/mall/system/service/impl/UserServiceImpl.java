package com.strr.mall.system.service.impl;

import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.repository.UserRepository;
import com.strr.mall.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 保存用户
     * @param user
     * @param oldRids
     * @param newRids
     */
    @Override
    public void saveWithRids(User user, Integer[] oldRids, Integer[] newRids) {
        if (user.getPassword() == null) {
            String password = new BCryptPasswordEncoder().encode("abc123");
            user.setPassword(password);
        }
        userRepository.save(user);
        List<Integer> oldRidList = oldRids != null ? Arrays.asList(oldRids) : new ArrayList<>();
        List<Integer> newRidList = newRids != null ? Arrays.asList(newRids) : new ArrayList<>();
        // 删除角色
        List<Integer> removeRids = new ArrayList<>();
        removeRids.addAll(oldRidList);
        removeRids.removeAll(newRidList);
        userRepository.deleteRel(user.getId(), removeRids);
        // 添加角色
        List<Integer> addRids = new ArrayList<>();
        addRids.addAll(newRidList);
        addRids.removeAll(oldRidList);
        userRepository.saveRel(user.getId(), addRids);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
        userRepository.deleteRelByUid(id);
    }

    /**
     * 获取用户角色关系
     * @param uid
     * @return
     */
    @Override
    public List<Integer> listRelByUid(Integer uid) {
        return userRepository.listRelByUid(uid);
    }
}
