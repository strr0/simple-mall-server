package com.strr.mall.product.controller;

import com.strr.mall.base.controller.CommonController;
import com.strr.mall.base.service.CommonService;
import com.strr.mall.product.entity.Product;
import com.strr.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 * @author strr
 */
@RestController
@RequestMapping("/product/product")
public class ProductController extends CommonController<Product, Integer> {
    @Autowired
    private ProductService productService;

    @Override
    protected CommonService<Product, Integer> getService() {
        return productService;
    }
}
