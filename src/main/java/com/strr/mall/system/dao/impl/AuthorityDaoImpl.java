package com.strr.mall.system.dao.impl;

import com.strr.mall.system.dao.AuthorityDao;
import com.strr.mall.system.entity.Authority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 权限
 * @author strr
 */
public class AuthorityDaoImpl implements AuthorityDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 获取用户权限
     * @param uid
     * @return
     */
    @Override
    public List<Authority> listByUserId(Integer uid) {
        String sql = "select * from sys_authority t1 where t1.id in ( " +
                "select distinct(t2.aid) from sys_rel_role_authority t2 left join sys_rel_user_role t3 on t2.rid = t3.rid " +
                "where t3.uid = :uid ) ";
        Query query = entityManager.createNativeQuery(sql, Authority.class);
        query.setParameter("uid", uid);
        return query.getResultList();
    }
}
