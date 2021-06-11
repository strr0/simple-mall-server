package com.strr.mall.common.minio.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    void upload(MultipartFile file);
    void remove(String objectName);
    String getPresignedUrl(String objectName);
}
