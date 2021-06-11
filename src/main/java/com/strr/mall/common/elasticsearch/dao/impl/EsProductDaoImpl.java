package com.strr.mall.common.elasticsearch.dao.impl;

import com.strr.mall.common.elasticsearch.dao.EsProductDao;
import com.strr.mall.common.elasticsearch.entity.EsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EsProductDaoImpl implements EsProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EsProduct> esProductRowMapper = (rs, rowNum) -> {
        EsProduct esProduct = new EsProduct();
        esProduct.setId(rs.getInt("id"));
        esProduct.setName(rs.getString("name"));
        esProduct.setBrandId(rs.getInt("brand_id"));
        esProduct.setBrandName(rs.getString("brand_name"));
        esProduct.setCategoryId(rs.getInt("category_id"));
        esProduct.setCategoryName(rs.getString("category_name"));
        esProduct.setPublishStatus(rs.getString("publish_status"));
        esProduct.setVerifyStatus(rs.getString("verify_status"));
        esProduct.setPrice(rs.getDouble("price"));
        esProduct.setStock(rs.getInt("stock"));
        esProduct.setSeq(rs.getInt("seq"));
        return esProduct;
    };

    @Override
    public List<EsProduct> findAll() {
        String sql = "select t1.id, t1.name, t1.brand_id, t2.name brand_name, t1.category_id, t3.name category_name," +
                "t1.publish_status, t1.verify_status, t1.price, t1.stock, t1.seq from pms_product t1 left join " +
                "pms_product_brand t2 on t1.brand_id = t2.id left join pms_product_category t3 on t1.category_id = t3.id ";
        return jdbcTemplate.query(sql, esProductRowMapper);
    }

    @Override
    public EsProduct findById(Integer id) {
        String sql = "select t1.id, t1.name, t1.brand_id, t2.name brand_name, t1.category_id, t3.name category_name," +
                "t1.publish_status, t1.verify_status, t1.price, t1.stock, t1.seq from pms_product t1 left join " +
                "pms_product_brand t2 on t1.brand_id = t2.id left join pms_product_categoty t3 on t1.category_id = t3.id " +
                "where t1.id = ? ";
        List<EsProduct> dataList = jdbcTemplate.query(sql, new Object[] {id}, esProductRowMapper);
        if (dataList.size() > 0) {
            return dataList.get(0);
        }
        return null;
    }
}
