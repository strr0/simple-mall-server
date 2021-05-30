package com.strr.mall.common.jpa.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.jpa.service.CommonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public abstract class CommonController<T, PK extends Serializable> {
    protected abstract CommonService<T, PK> getService();

    /**
     * 列表
     * @return
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public CommonResult list() {
        CommonResult result = new CommonResult();
        try {
            result.setData(getService().findAll());
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 保存
     * @param t
     * @return
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public CommonResult save(T t) {
        CommonResult result = new CommonResult();
        try {
            getService().save(t);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @ApiOperation("详情")
    @GetMapping("/detail/{id}")
    public CommonResult detail(@PathVariable("id") PK id) {
        CommonResult result = new CommonResult();
        try {
            result.setData(getService().findById(id));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam PK id) {
        CommonResult result = new CommonResult();
        try {
            getService().deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 分页
     * @param t
     * @param pageable
     * @return
     */
    @ApiOperation("分页")
    @GetMapping("/page")
    public CommonResult page(T t, Pageable pageable) {
        CommonResult result = new CommonResult();
        try {
            result.setData(getService().findAll(t, pageable));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
