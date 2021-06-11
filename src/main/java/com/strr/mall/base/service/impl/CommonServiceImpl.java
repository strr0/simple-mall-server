package com.strr.mall.base.service.impl;

import com.strr.mall.base.service.CommonService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CommonServiceImpl<T, PK extends Serializable> implements CommonService<T, PK> {
    protected abstract JpaRepository<T, PK> getJpaRepository();

    /**
     * 列表
     * @return
     */
    @Override
    public List<T> findAll() {
        return getJpaRepository().findAll();
    }

    /**
     * 保存
     * @param t
     */
    @Override
    public void save(T t) {
        getJpaRepository().save(t);
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public T findById(PK id) {
        Optional<T> optional = getJpaRepository().findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(PK id) {
        getJpaRepository().deleteById(id);
    }

    /**
     * 分页
     * @param t
     * @param pageable
     * @return
     */
    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        Example<T> example = Example.of(t);
        return getJpaRepository().findAll(example, pageable);
    }
}
