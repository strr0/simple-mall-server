package com.strr.mall.system.repository;

import com.strr.mall.system.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 字典
 * @author strr
 */
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
}
