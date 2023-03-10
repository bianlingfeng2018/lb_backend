package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class TestWorkOrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestWorkOrderItemExample() {
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

        public Criteria andTestWorkOrderIdIsNull() {
            addCriterion("test_work_order_id is null");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdIsNotNull() {
            addCriterion("test_work_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdEqualTo(Long value) {
            addCriterion("test_work_order_id =", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdNotEqualTo(Long value) {
            addCriterion("test_work_order_id <>", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdGreaterThan(Long value) {
            addCriterion("test_work_order_id >", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_work_order_id >=", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdLessThan(Long value) {
            addCriterion("test_work_order_id <", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("test_work_order_id <=", value, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdIn(List<Long> values) {
            addCriterion("test_work_order_id in", values, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdNotIn(List<Long> values) {
            addCriterion("test_work_order_id not in", values, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdBetween(Long value1, Long value2) {
            addCriterion("test_work_order_id between", value1, value2, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andTestWorkOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("test_work_order_id not between", value1, value2, "testWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andSampleLocationIsNull() {
            addCriterion("sample_location is null");
            return (Criteria) this;
        }

        public Criteria andSampleLocationIsNotNull() {
            addCriterion("sample_location is not null");
            return (Criteria) this;
        }

        public Criteria andSampleLocationEqualTo(String value) {
            addCriterion("sample_location =", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationNotEqualTo(String value) {
            addCriterion("sample_location <>", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationGreaterThan(String value) {
            addCriterion("sample_location >", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationGreaterThanOrEqualTo(String value) {
            addCriterion("sample_location >=", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationLessThan(String value) {
            addCriterion("sample_location <", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationLessThanOrEqualTo(String value) {
            addCriterion("sample_location <=", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationLike(String value) {
            addCriterion("sample_location like", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationNotLike(String value) {
            addCriterion("sample_location not like", value, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationIn(List<String> values) {
            addCriterion("sample_location in", values, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationNotIn(List<String> values) {
            addCriterion("sample_location not in", values, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationBetween(String value1, String value2) {
            addCriterion("sample_location between", value1, value2, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleLocationNotBetween(String value1, String value2) {
            addCriterion("sample_location not between", value1, value2, "sampleLocation");
            return (Criteria) this;
        }

        public Criteria andSampleModelIsNull() {
            addCriterion("sample_model is null");
            return (Criteria) this;
        }

        public Criteria andSampleModelIsNotNull() {
            addCriterion("sample_model is not null");
            return (Criteria) this;
        }

        public Criteria andSampleModelEqualTo(String value) {
            addCriterion("sample_model =", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelNotEqualTo(String value) {
            addCriterion("sample_model <>", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelGreaterThan(String value) {
            addCriterion("sample_model >", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelGreaterThanOrEqualTo(String value) {
            addCriterion("sample_model >=", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelLessThan(String value) {
            addCriterion("sample_model <", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelLessThanOrEqualTo(String value) {
            addCriterion("sample_model <=", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelLike(String value) {
            addCriterion("sample_model like", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelNotLike(String value) {
            addCriterion("sample_model not like", value, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelIn(List<String> values) {
            addCriterion("sample_model in", values, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelNotIn(List<String> values) {
            addCriterion("sample_model not in", values, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelBetween(String value1, String value2) {
            addCriterion("sample_model between", value1, value2, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleModelNotBetween(String value1, String value2) {
            addCriterion("sample_model not between", value1, value2, "sampleModel");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialIsNull() {
            addCriterion("sample_material is null");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialIsNotNull() {
            addCriterion("sample_material is not null");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialEqualTo(String value) {
            addCriterion("sample_material =", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialNotEqualTo(String value) {
            addCriterion("sample_material <>", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialGreaterThan(String value) {
            addCriterion("sample_material >", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("sample_material >=", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialLessThan(String value) {
            addCriterion("sample_material <", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialLessThanOrEqualTo(String value) {
            addCriterion("sample_material <=", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialLike(String value) {
            addCriterion("sample_material like", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialNotLike(String value) {
            addCriterion("sample_material not like", value, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialIn(List<String> values) {
            addCriterion("sample_material in", values, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialNotIn(List<String> values) {
            addCriterion("sample_material not in", values, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialBetween(String value1, String value2) {
            addCriterion("sample_material between", value1, value2, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleMaterialNotBetween(String value1, String value2) {
            addCriterion("sample_material not between", value1, value2, "sampleMaterial");
            return (Criteria) this;
        }

        public Criteria andSampleDescIsNull() {
            addCriterion("sample_desc is null");
            return (Criteria) this;
        }

        public Criteria andSampleDescIsNotNull() {
            addCriterion("sample_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSampleDescEqualTo(String value) {
            addCriterion("sample_desc =", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescNotEqualTo(String value) {
            addCriterion("sample_desc <>", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescGreaterThan(String value) {
            addCriterion("sample_desc >", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescGreaterThanOrEqualTo(String value) {
            addCriterion("sample_desc >=", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescLessThan(String value) {
            addCriterion("sample_desc <", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescLessThanOrEqualTo(String value) {
            addCriterion("sample_desc <=", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescLike(String value) {
            addCriterion("sample_desc like", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescNotLike(String value) {
            addCriterion("sample_desc not like", value, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescIn(List<String> values) {
            addCriterion("sample_desc in", values, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescNotIn(List<String> values) {
            addCriterion("sample_desc not in", values, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescBetween(String value1, String value2) {
            addCriterion("sample_desc between", value1, value2, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andSampleDescNotBetween(String value1, String value2) {
            addCriterion("sample_desc not between", value1, value2, "sampleDesc");
            return (Criteria) this;
        }

        public Criteria andTestItemIdIsNull() {
            addCriterion("test_item_id is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIdIsNotNull() {
            addCriterion("test_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemIdEqualTo(Integer value) {
            addCriterion("test_item_id =", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotEqualTo(Integer value) {
            addCriterion("test_item_id <>", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdGreaterThan(Integer value) {
            addCriterion("test_item_id >", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_item_id >=", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdLessThan(Integer value) {
            addCriterion("test_item_id <", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_item_id <=", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdIn(List<Integer> values) {
            addCriterion("test_item_id in", values, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotIn(List<Integer> values) {
            addCriterion("test_item_id not in", values, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdBetween(Integer value1, Integer value2) {
            addCriterion("test_item_id between", value1, value2, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_item_id not between", value1, value2, "testItemId");
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

        public Criteria andTestItemMethodIsNull() {
            addCriterion("test_item_method is null");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodIsNotNull() {
            addCriterion("test_item_method is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodEqualTo(String value) {
            addCriterion("test_item_method =", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodNotEqualTo(String value) {
            addCriterion("test_item_method <>", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodGreaterThan(String value) {
            addCriterion("test_item_method >", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodGreaterThanOrEqualTo(String value) {
            addCriterion("test_item_method >=", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodLessThan(String value) {
            addCriterion("test_item_method <", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodLessThanOrEqualTo(String value) {
            addCriterion("test_item_method <=", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodLike(String value) {
            addCriterion("test_item_method like", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodNotLike(String value) {
            addCriterion("test_item_method not like", value, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodIn(List<String> values) {
            addCriterion("test_item_method in", values, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodNotIn(List<String> values) {
            addCriterion("test_item_method not in", values, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodBetween(String value1, String value2) {
            addCriterion("test_item_method between", value1, value2, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemMethodNotBetween(String value1, String value2) {
            addCriterion("test_item_method not between", value1, value2, "testItemMethod");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseIsNull() {
            addCriterion("test_item_case is null");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseIsNotNull() {
            addCriterion("test_item_case is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseEqualTo(String value) {
            addCriterion("test_item_case =", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseNotEqualTo(String value) {
            addCriterion("test_item_case <>", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseGreaterThan(String value) {
            addCriterion("test_item_case >", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseGreaterThanOrEqualTo(String value) {
            addCriterion("test_item_case >=", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseLessThan(String value) {
            addCriterion("test_item_case <", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseLessThanOrEqualTo(String value) {
            addCriterion("test_item_case <=", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseLike(String value) {
            addCriterion("test_item_case like", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseNotLike(String value) {
            addCriterion("test_item_case not like", value, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseIn(List<String> values) {
            addCriterion("test_item_case in", values, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseNotIn(List<String> values) {
            addCriterion("test_item_case not in", values, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseBetween(String value1, String value2) {
            addCriterion("test_item_case between", value1, value2, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andTestItemCaseNotBetween(String value1, String value2) {
            addCriterion("test_item_case not between", value1, value2, "testItemCase");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNull() {
            addCriterion("lab_id is null");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNotNull() {
            addCriterion("lab_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabIdEqualTo(Integer value) {
            addCriterion("lab_id =", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotEqualTo(Integer value) {
            addCriterion("lab_id <>", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThan(Integer value) {
            addCriterion("lab_id >", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lab_id >=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThan(Integer value) {
            addCriterion("lab_id <", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThanOrEqualTo(Integer value) {
            addCriterion("lab_id <=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdIn(List<Integer> values) {
            addCriterion("lab_id in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotIn(List<Integer> values) {
            addCriterion("lab_id not in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdBetween(Integer value1, Integer value2) {
            addCriterion("lab_id between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lab_id not between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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