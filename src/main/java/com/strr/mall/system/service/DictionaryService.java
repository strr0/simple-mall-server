package com.strr.mall.system.service;

import com.strr.mall.base.service.CommonService;
import com.strr.mall.system.entity.Dictionary;

import java.util.Map;

/**
 * 字典
 * @author strr
 */
public interface DictionaryService extends CommonService<Dictionary, Integer> {
    Map<String, Object> getCodePath();
}
