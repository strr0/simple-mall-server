package com.strr.mall.common.elasticsearch.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.elasticsearch.service.EsProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EsProductController", description = "商品管理")
@RestController
@RequestMapping("/es/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @PostMapping("/save/{id}")
    public CommonResult save(@PathVariable Integer id) {
        CommonResult result = new CommonResult();
        try {
            esProductService.save(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        CommonResult result = new CommonResult();
        try {
            esProductService.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping("/importData")
    public CommonResult importData() {
        CommonResult result = new CommonResult();
        try {
            esProductService.importData();
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/searchData")
    public CommonResult searchData(String keyword, Integer pageNum, Integer pageSize) {
        CommonResult result = new CommonResult();
        try {
            result.setData(esProductService.searchData(keyword, pageNum, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
