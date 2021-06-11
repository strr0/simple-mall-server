package com.strr.mall.product.service.impl;

import com.strr.mall.base.service.impl.CommonServiceImpl;
import com.strr.mall.product.entity.Product;
import com.strr.mall.product.repository.ProductRepository;
import com.strr.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 商品
 * @author strr
 */
@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, Integer> implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    protected JpaRepository<Product, Integer> getJpaRepository() {
        return productRepository;
    }
}
