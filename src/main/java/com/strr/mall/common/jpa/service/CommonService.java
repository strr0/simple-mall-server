package com.strr.mall.common.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface CommonService<T, PK extends Serializable> {
    /**
     * 列表
     * @return
     */
    List<T> findAll();

    /**
     * 保存
     * @param t
     */
    void save(T t);

    /**
     * 详情
     * @param id
     * @return
     */
    T findById(PK id);

    /**
     * 删除
     * @param id
     */
    void deleteById(PK id);

    /**
     * 分页
     * @param t
     * @param pageable
     * @return
     */
    Page<T> findAll(T t, Pageable pageable);
}
