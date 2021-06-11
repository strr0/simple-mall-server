package com.strr.mall.common.elasticsearch.service;

import com.strr.mall.common.elasticsearch.entity.EsProduct;
import org.springframework.data.domain.Page;

public interface EsProductService {
    void save(Integer id);
    void deleteById(Integer id);
    int importData();
    Page<EsProduct> searchData(String keyword, Integer pageNum, Integer pageSize);
}
