package com.strr.mall.product.controller;

import com.strr.mall.base.controller.CommonController;
import com.strr.mall.base.service.CommonService;
import com.strr.mall.product.entity.ProductBrand;
import com.strr.mall.product.service.ProductBrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品品牌
 * @author strr
 */
@Api(tags = "ProductBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/product/productBrand")
public class ProductBrandController extends CommonController<ProductBrand, Integer> {
    @Autowired
    private ProductBrandService productBrandService;

    @Override
    protected CommonService<ProductBrand, Integer> getService() {
        return productBrandService;
    }
}
