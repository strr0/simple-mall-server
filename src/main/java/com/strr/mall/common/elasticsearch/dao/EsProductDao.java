package com.strr.mall.common.elasticsearch.dao;

import com.strr.mall.common.elasticsearch.entity.EsProduct;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> findAll();
    EsProduct findById(Integer id);
}
