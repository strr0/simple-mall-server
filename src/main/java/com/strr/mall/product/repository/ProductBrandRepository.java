package com.strr.mall.product.repository;

import com.strr.mall.product.entity.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品品牌
 * @author strr
 */
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer> {
}
