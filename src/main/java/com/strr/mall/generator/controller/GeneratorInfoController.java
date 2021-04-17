package com.strr.mall.generator.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.generator.entity.GeneratorInfo;
import com.strr.mall.generator.service.GeneratorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator/generatorInfo")
public class GeneratorInfoController {
    @Autowired
    private GeneratorInfoService generatorInfoService;

    /**
     * 生成代码
     * @param info
     * @return
     */
    @PostMapping("/generatorCode")
    public CommonResult generatorCode(GeneratorInfo info) {
        CommonResult result = new CommonResult();
        try {
            generatorInfoService.generatorCode(info);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
