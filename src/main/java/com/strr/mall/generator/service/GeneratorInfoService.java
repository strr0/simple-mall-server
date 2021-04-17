package com.strr.mall.generator.service;

import com.strr.mall.generator.entity.GeneratorInfo;

public interface GeneratorInfoService {
    /**
     * 生成代码
     * @param info
     */
    void generatorCode(GeneratorInfo info);
}
