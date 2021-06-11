package com.strr.mall.common.elasticsearch.repository;

import com.strr.mall.common.elasticsearch.entity.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Integer> {
    Page<EsProduct> findByNameOrBrandNameOrCategoryName(String name, String brandName, String categoryName, Pageable page);
}
