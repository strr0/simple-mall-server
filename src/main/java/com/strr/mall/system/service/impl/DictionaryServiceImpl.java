package com.strr.mall.system.service.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.common.jpa.service.impl.CommonServiceImpl;
import com.strr.mall.system.entity.Dictionary;
import com.strr.mall.system.repository.DictionaryRepository;
import com.strr.mall.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典
 * @author strr
 */
@Service
public class DictionaryServiceImpl extends CommonServiceImpl<Dictionary, Integer> implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    protected JpaRepository<Dictionary, Integer> getJpaRepository() {
        return dictionaryRepository;
    }

    /**
     * 字典树
     * @return
     */
    @Override
    public List<Dictionary> findAll() {
        List<Dictionary> dictionaryList = dictionaryRepository.findAll();
        List<Dictionary> dictionaryTree = new ArrayList<>();
        for (Dictionary dictionary : dictionaryList) {
            if (Constant.DICT_ROOT_ID.equals(dictionary.getParentId())) {
                Dictionary node = new Dictionary(dictionary);
                node.setChildren(getDictionaryNodes(dictionary.getId(), dictionaryList));
                dictionaryTree.add(node);
            }
        }
        return dictionaryTree;
    }

    /**
     * 获取子字典
     * @param id
     * @param dictionaryList
     * @return
     */
    private List<Dictionary> getDictionaryNodes(Integer id, List<Dictionary> dictionaryList) {
        List<Dictionary> items = new ArrayList<>();
        for (Dictionary dictionary : dictionaryList) {
            if (id.equals(dictionary.getParentId())) {
                Dictionary item = new Dictionary(dictionary);
                item.setChildren(getDictionaryNodes(dictionary.getId(), dictionaryList));
                items.add(item);
            }
        }
        return items;
    }
}
