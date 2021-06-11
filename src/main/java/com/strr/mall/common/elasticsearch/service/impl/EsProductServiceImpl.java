package com.strr.mall.common.elasticsearch.service.impl;

import com.strr.mall.common.elasticsearch.dao.EsProductDao;
import com.strr.mall.common.elasticsearch.entity.EsProduct;
import com.strr.mall.common.elasticsearch.repository.EsProductRepository;
import com.strr.mall.common.elasticsearch.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductDao esProductDao;

    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public void save(Integer id) {
        EsProduct esProduct = esProductDao.findById(id);
        if (esProduct != null) {
            esProductRepository.save(esProduct);
        }
    }

    @Override
    public void deleteById(Integer id) {
        esProductRepository.deleteById(id);
    }

    @Override
    public int importData() {
        List<EsProduct> dataList = esProductDao.findAll();
        Iterable<EsProduct> iterable = esProductRepository.saveAll(dataList);
        Iterator<EsProduct> iterator = iterable.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    @Override
    public Page<EsProduct> searchData(String keyword, Integer pageNum, Integer pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrBrandNameOrCategoryName(keyword, keyword, keyword, page);
    }
}
