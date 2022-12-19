package com.libiao.customer.dal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MallGoods {
    private Long id;

    private String goodsNum;

    private String goodsName;

    private String price;

    private String description;

    private String testItemList;
    private String hscode;
    private String material;
    private String export;
    private String platform;
    private String standard;
    private String industClass;
    private String busType;
    private String subtitle;
    private String mealList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTestItemList() {
        return testItemList;
    }

    public void setTestItemList(String testItemList) {
        this.testItemList = testItemList;
    }
}