package com.strr.mall.system.repository;

import com.strr.mall.system.dao.RoleDao;
import com.strr.mall.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色
 * @author strr
 */
public interface RoleRepository extends JpaRepository<Role, Integer>, RoleDao {
}
