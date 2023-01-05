package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestQuotationItem implements Serializable {
    private Long id;

    private String testQuotationNum;

    private Long testQuotationGoodsId;

    private String testItem;

    private Integer itemId;

    private Integer unitPrice;

    private Integer quantity;

    private Integer amountRmb;

    private Integer sampleQty;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestQuotationNum() {
        return testQuotationNum;
    }

    public void setTestQuotationNum(String testQuotationNum) {
        this.testQuotationNum = testQuotationNum;
    }

    public Long getTestQuotationGoodsId() {
        return testQuotationGoodsId;
    }

    public void setTestQuotationGoodsId(Long testQuotationGoodsId) {
        this.testQuotationGoodsId = testQuotationGoodsId;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmountRmb() {
        return amountRmb;
    }

    public void setAmountRmb(Integer amountRmb) {
        this.amountRmb = amountRmb;
    }

    public Integer getSampleQty() {
        return sampleQty;
    }

    public void setSampleQty(Integer sampleQty) {
        this.sampleQty = sampleQty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", testQuotationNum=").append(testQuotationNum);
        sb.append(", testQuotationGoodsId=").append(testQuotationGoodsId);
        sb.append(", testItem=").append(testItem);
        sb.append(", itemId=").append(itemId);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", amountRmb=").append(amountRmb);
        sb.append(", sampleQty=").append(sampleQty);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}