package com.strr.mall.common.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "pms", type = "product", shards = 1, replicas = 0)
public class EsProduct {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 商品名称
     */
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;

    /**
     * 商品品牌ID
     */
    private Integer brandId;

    /**
     * 商品品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 商品分类ID
     */
    private Integer categoryId;

    /**
     * 商品分类名称
     */
    @Field(type = FieldType.Keyword)
    private String categoryName;

    /**
     * 上架状态
     */
    private String publishStatus;

    /**
     * 审核状态
     */
    private String verifyStatus;

    /**
     * 价铬
     */
    private Double price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 排序
     */
    private Integer seq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
