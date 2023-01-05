package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class TestQuotationItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestQuotationItemExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumIsNull() {
            addCriterion("test_quotation_num is null");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumIsNotNull() {
            addCriterion("test_quotation_num is not null");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumEqualTo(String value) {
            addCriterion("test_quotation_num =", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumNotEqualTo(String value) {
            addCriterion("test_quotation_num <>", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumGreaterThan(String value) {
            addCriterion("test_quotation_num >", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumGreaterThanOrEqualTo(String value) {
            addCriterion("test_quotation_num >=", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumLessThan(String value) {
            addCriterion("test_quotation_num <", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumLessThanOrEqualTo(String value) {
            addCriterion("test_quotation_num <=", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumLike(String value) {
            addCriterion("test_quotation_num like", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumNotLike(String value) {
            addCriterion("test_quotation_num not like", value, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumIn(List<String> values) {
            addCriterion("test_quotation_num in", values, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumNotIn(List<String> values) {
            addCriterion("test_quotation_num not in", values, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumBetween(String value1, String value2) {
            addCriterion("test_quotation_num between", value1, value2, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationNumNotBetween(String value1, String value2) {
            addCriterion("test_quotation_num not between", value1, value2, "testQuotationNum");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdIsNull() {
            addCriterion("test_quotation_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdIsNotNull() {
            addCriterion("test_quotation_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdEqualTo(Long value) {
            addCriterion("test_quotation_goods_id =", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdNotEqualTo(Long value) {
            addCriterion("test_quotation_goods_id <>", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdGreaterThan(Long value) {
            addCriterion("test_quotation_goods_id >", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_quotation_goods_id >=", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdLessThan(Long value) {
            addCriterion("test_quotation_goods_id <", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("test_quotation_goods_id <=", value, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdIn(List<Long> values) {
            addCriterion("test_quotation_goods_id in", values, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdNotIn(List<Long> values) {
            addCriterion("test_quotation_goods_id not in", values, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdBetween(Long value1, Long value2) {
            addCriterion("test_quotation_goods_id between", value1, value2, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestQuotationGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("test_quotation_goods_id not between", value1, value2, "testQuotationGoodsId");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNull() {
            addCriterion("test_item is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNotNull() {
            addCriterion("test_item is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemEqualTo(String value) {
            addCriterion("test_item =", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotEqualTo(String value) {
            addCriterion("test_item <>", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThan(String value) {
            addCriterion("test_item >", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThanOrEqualTo(String value) {
            addCriterion("test_item >=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThan(String value) {
            addCriterion("test_item <", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThanOrEqualTo(String value) {
            addCriterion("test_item <=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLike(String value) {
            addCriterion("test_item like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotLike(String value) {
            addCriterion("test_item not like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemIn(List<String> values) {
            addCriterion("test_item in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotIn(List<String> values) {
            addCriterion("test_item not in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemBetween(String value1, String value2) {
            addCriterion("test_item between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotBetween(String value1, String value2) {
            addCriterion("test_item not between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Integer value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Integer value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Integer value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Integer value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Integer> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Integer> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andAmountRmbIsNull() {
            addCriterion("amount_rmb is null");
            return (Criteria) this;
        }

        public Criteria andAmountRmbIsNotNull() {
            addCriterion("amount_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andAmountRmbEqualTo(Integer value) {
            addCriterion("amount_rmb =", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbNotEqualTo(Integer value) {
            addCriterion("amount_rmb <>", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbGreaterThan(Integer value) {
            addCriterion("amount_rmb >", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount_rmb >=", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbLessThan(Integer value) {
            addCriterion("amount_rmb <", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbLessThanOrEqualTo(Integer value) {
            addCriterion("amount_rmb <=", value, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbIn(List<Integer> values) {
            addCriterion("amount_rmb in", values, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbNotIn(List<Integer> values) {
            addCriterion("amount_rmb not in", values, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbBetween(Integer value1, Integer value2) {
            addCriterion("amount_rmb between", value1, value2, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andAmountRmbNotBetween(Integer value1, Integer value2) {
            addCriterion("amount_rmb not between", value1, value2, "amountRmb");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIsNull() {
            addCriterion("sample_qty is null");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIsNotNull() {
            addCriterion("sample_qty is not null");
            return (Criteria) this;
        }

        public Criteria andSampleQtyEqualTo(Integer value) {
            addCriterion("sample_qty =", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotEqualTo(Integer value) {
            addCriterion("sample_qty <>", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyGreaterThan(Integer value) {
            addCriterion("sample_qty >", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sample_qty >=", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyLessThan(Integer value) {
            addCriterion("sample_qty <", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyLessThanOrEqualTo(Integer value) {
            addCriterion("sample_qty <=", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIn(List<Integer> values) {
            addCriterion("sample_qty in", values, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotIn(List<Integer> values) {
            addCriterion("sample_qty not in", values, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyBetween(Integer value1, Integer value2) {
            addCriterion("sample_qty between", value1, value2, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("sample_qty not between", value1, value2, "sampleQty");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}