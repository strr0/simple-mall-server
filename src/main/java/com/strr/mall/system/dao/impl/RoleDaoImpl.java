package com.strr.mall.system.dao.impl;

import com.strr.mall.system.dao.RoleDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 角色
 * @author strr
 */
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 获取角色权限关系
     * @param rid
     * @return
     */
    @Override
    public List<Integer> listRelByRid(Integer rid) {
        Query query = entityManager.createNativeQuery("select aid from sys_rel_role_authority where rid = :rid ");
        query.setParameter("rid", rid);
        return query.getResultList();
    }

    /**
     * 保存角色权限关系
     * @param rid
     * @param aids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRel(Integer rid, List<Integer> aids) {
        for (Integer aid : aids) {
            entityManager.createNativeQuery("insert into sys_rel_role_authority (rid, aid) values ( :rid, :aid ) ")
                    .setParameter("rid", rid).setParameter("aid", aid).executeUpdate();
        }
    }

    /**
     * 删除角色权限关系
     * @param rid
     * @param aids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRel(Integer rid, List<Integer> aids) {
        for (Integer aid : aids) {
            entityManager.createNativeQuery("delete from sys_rel_role_authority where rid = :rid and aid = :aid ")
                    .setParameter("rid", rid).setParameter("aid", aid).executeUpdate();
        }
    }
}
