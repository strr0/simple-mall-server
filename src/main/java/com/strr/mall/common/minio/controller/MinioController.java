package com.strr.mall.common.minio.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.minio.service.MinioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "MinioController", description = "文件管理")
@RestController
@RequestMapping("/common/minio")
public class MinioController {
    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        CommonResult result = new CommonResult();
        try {
            minioService.upload(file);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @DeleteMapping("/remove")
    public CommonResult remove(String objectName) {
        CommonResult result = new CommonResult();
        try {
            minioService.remove(objectName);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/getPresignedUrl")
    public CommonResult getPresignedUrl(String objectName) {
        CommonResult result = new CommonResult();
        try {
            result.setData(minioService.getPresignedUrl(objectName));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
