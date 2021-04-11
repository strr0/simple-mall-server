package com.strr.mall.generator.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.generator.service.ColumnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator/columnInfo")
public class ColumnInfoController {
    @Autowired
    private ColumnInfoService columnInfoService;

    @GetMapping("/getColumnInfoList")
    public CommonResult getColumnInfoList(String schema, String table) {
        CommonResult result = new CommonResult();
        try {
            result.setData(columnInfoService.getColumnInfoList(schema, table));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
