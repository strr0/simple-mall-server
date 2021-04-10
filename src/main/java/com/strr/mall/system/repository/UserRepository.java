package com.strr.mall.system.repository;

import com.strr.mall.system.dao.UserDao;
import com.strr.mall.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户
 * @author strr
 */
public interface UserRepository extends JpaRepository<User, Integer>, UserDao {
    /**
     * 获取用户
     * @param username
     * @return
     */
    User getByUsername(String username);
}
