package com.strr.mall.system.dao.impl;

import com.strr.mall.system.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 用户
 * @author strr
 */
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 获取用户角色关系
     * @param uid
     * @return
     */
    @Override
    public List<Integer> listRelByUid(Integer uid) {
        Query query = entityManager.createNativeQuery("select rid from sys_rel_user_role where uid = :uid ");
        query.setParameter("uid", uid);
        return query.getResultList();
    }

    /**
     * 保存用户角色关系
     * @param uid
     * @param rids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRel(Integer uid, List<Integer> rids) {
        for (Integer rid : rids) {
            entityManager.createNativeQuery("insert sys_rel_user_role (uid, rid) values ( :uid, :rid ) ")
                    .setParameter("uid", uid).setParameter("rid", rid).executeUpdate();
        }
    }

    /**
     * 删除用户角色关系
     * @param uid
     * @param rids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRel(Integer uid, List<Integer> rids) {
        for (Integer rid : rids) {
            entityManager.createNativeQuery("delete from sys_rel_user_role where uid = :uid and rid = :rid ")
                    .setParameter("uid", uid).setParameter("rid", rid).executeUpdate();
        }
    }

    /**
     * 根据uid删除
     * @param uid
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRelByUid(Integer uid) {
        entityManager.createNativeQuery("delete from sys_rel_user_role where uid = :uid ")
                .setParameter("uid", uid).executeUpdate();
    }
}
