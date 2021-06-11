package com.strr.mall.common.mongo.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.mongo.entity.MgReadHistory;
import com.strr.mall.common.mongo.service.MgReadHistoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "MgReadHistoryController", description = "浏览历史管理")
@RestController
@RequestMapping("/mg/readHistory")
public class MgReadHistoryController {
    @Autowired
    private MgReadHistoryService mgReadHistoryService;

    @PostMapping("/save")
    public CommonResult save(MgReadHistory mgReadHistory) {
        CommonResult result = new CommonResult();
        try {
            mgReadHistoryService.save(mgReadHistory);
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
            mgReadHistoryService.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/list")
    public CommonResult list(Integer userId) {
        CommonResult result = new CommonResult();
        try {
            result.setData(mgReadHistoryService.findByUserId(userId));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
