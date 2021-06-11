package com.strr.mall.product.repository;

import com.strr.mall.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品
 * @author strr
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
