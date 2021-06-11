package com.strr.mall.common.minio.service.impl;

import com.strr.mall.common.minio.service.MinioService;
import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MinioServiceImpl implements MinioService {
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;

    @Autowired
    private MinioClient minioClient;

    /**
     * 文件上传
     * @param file
     */
    @Override
    public void upload(MultipartFile file) {
        try (InputStream in = file.getInputStream()) {
            // 判断桶是否存在
            boolean bucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!bucketExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            }
            String fileName = file.getOriginalFilename();
            String objectName = fileName + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date());
            String contentType = file.getContentType();
            // 上传文件
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .stream(in, file.getSize(), -1)
                    .contentType(contentType)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 文件删除
     * @param objectName
     */
    @Override
    public void remove(String objectName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 获取文件url
     * @param objectName
     * @return
     */
    @Override
    public String getPresignedUrl(String objectName) {
        try {
            minioClient.statObject(StatObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .build());
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .bucket(BUCKET_NAME)
                    .method(Method.GET)
                    .object(objectName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
