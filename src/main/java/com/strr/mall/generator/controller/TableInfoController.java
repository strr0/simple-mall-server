package com.strr.mall.generator.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.generator.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator/tableInfo")
public class TableInfoController {
    @Autowired
    private TableInfoService tableInfoService;

    @GetMapping("/getTableInfoPage")
    public CommonResult getTableInfoPage(Integer page, Integer size) {
        CommonResult result = new CommonResult();
        try {
            result.setData(tableInfoService.getTableInfoPage(page, size));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
