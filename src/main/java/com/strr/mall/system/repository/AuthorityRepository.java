package com.strr.mall.system.repository;

import com.strr.mall.system.dao.AuthorityDao;
import com.strr.mall.system.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 权限
 * @author strr
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer>, AuthorityDao {
}
