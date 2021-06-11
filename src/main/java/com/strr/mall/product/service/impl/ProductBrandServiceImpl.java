package com.strr.mall.product.service.impl;

import com.strr.mall.base.service.impl.CommonServiceImpl;
import com.strr.mall.product.entity.ProductBrand;
import com.strr.mall.product.repository.ProductBrandRepository;
import com.strr.mall.product.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 商品品牌
 * @author strr
 */
@Service
public class ProductBrandServiceImpl extends CommonServiceImpl<ProductBrand, Integer> implements ProductBrandService {
    @Autowired
    private ProductBrandRepository productBrandRepository;

    @Override
    protected JpaRepository<ProductBrand, Integer> getJpaRepository() {
        return productBrandRepository;
    }
}
