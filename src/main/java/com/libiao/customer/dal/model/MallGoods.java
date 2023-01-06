package com.libiao.customer.dal.model;

import java.io.Serializable;

public class MallGoods implements Serializable {
    private Long id;

    private String goodsNum;

    private String goodsName;

    private String price;

    private String description;

    private String hscode;

    private String material;

    private String export;

    private String platform;

    private String standard;

    private String industClass;

    private Byte busType;

    private String subtitle;

    private String attr1;

    private String attr2;

    private String attr3;

    private String testItemList;

    private String mealList;

    private static final long serialVersionUID = 1L;

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

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getIndustClass() {
        return industClass;
    }

    public void setIndustClass(String industClass) {
        this.industClass = industClass;
    }

    public Byte getBusType() {
        return busType;
    }

    public void setBusType(Byte busType) {
        this.busType = busType;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getTestItemList() {
        return testItemList;
    }

    public void setTestItemList(String testItemList) {
        this.testItemList = testItemList;
    }

    public String getMealList() {
        return mealList;
    }

    public void setMealList(String mealList) {
        this.mealList = mealList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append(", hscode=").append(hscode);
        sb.append(", material=").append(material);
        sb.append(", export=").append(export);
        sb.append(", platform=").append(platform);
        sb.append(", standard=").append(standard);
        sb.append(", industClass=").append(industClass);
        sb.append(", busType=").append(busType);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", attr1=").append(attr1);
        sb.append(", attr2=").append(attr2);
        sb.append(", attr3=").append(attr3);
        sb.append(", testItemList=").append(testItemList);
        sb.append(", mealList=").append(mealList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}