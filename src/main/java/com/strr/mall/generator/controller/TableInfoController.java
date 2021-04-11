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

    @GetMapping("/getTableInfoList")
    public CommonResult getTableInfoList(String schema, String table) {
        CommonResult result = new CommonResult();
        try {
            result.setData(tableInfoService.getTableInfoList(schema, table));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
