package com.strr.mall.system.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.jpa.controller.CommonController;
import com.strr.mall.common.jpa.service.CommonService;
import com.strr.mall.system.entity.Dictionary;
import com.strr.mall.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典
 * @author strr
 */
@RestController
@RequestMapping("/system/dictionary")
public class DictionaryController extends CommonController<Dictionary, Integer> {
    @Autowired
    private DictionaryService dictionaryService;

    @Override
    protected CommonService<Dictionary, Integer> getService() {
        return dictionaryService;
    }

    /**
     * 获取代码路径
     * @return
     */
    @GetMapping("/getCodePath")
    public CommonResult getCodePath() {
        CommonResult result = new CommonResult();
        try {
            result.setData(dictionaryService.getCodePath());
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
