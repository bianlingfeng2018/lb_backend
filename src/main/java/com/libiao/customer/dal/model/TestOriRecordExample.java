package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestOriRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestOriRecordExample() {
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

        public Criteria andRecordNumIsNull() {
            addCriterion("record_num is null");
            return (Criteria) this;
        }

        public Criteria andRecordNumIsNotNull() {
            addCriterion("record_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNumEqualTo(String value) {
            addCriterion("record_num =", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotEqualTo(String value) {
            addCriterion("record_num <>", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThan(String value) {
            addCriterion("record_num >", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThanOrEqualTo(String value) {
            addCriterion("record_num >=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThan(String value) {
            addCriterion("record_num <", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThanOrEqualTo(String value) {
            addCriterion("record_num <=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLike(String value) {
            addCriterion("record_num like", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotLike(String value) {
            addCriterion("record_num not like", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumIn(List<String> values) {
            addCriterion("record_num in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotIn(List<String> values) {
            addCriterion("record_num not in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumBetween(String value1, String value2) {
            addCriterion("record_num between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotBetween(String value1, String value2) {
            addCriterion("record_num not between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIsNull() {
            addCriterion("work_order_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIsNotNull() {
            addCriterion("work_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumEqualTo(String value) {
            addCriterion("work_order_num =", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotEqualTo(String value) {
            addCriterion("work_order_num <>", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThan(String value) {
            addCriterion("work_order_num >", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_num >=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThan(String value) {
            addCriterion("work_order_num <", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThanOrEqualTo(String value) {
            addCriterion("work_order_num <=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLike(String value) {
            addCriterion("work_order_num like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotLike(String value) {
            addCriterion("work_order_num not like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIn(List<String> values) {
            addCriterion("work_order_num in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotIn(List<String> values) {
            addCriterion("work_order_num not in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumBetween(String value1, String value2) {
            addCriterion("work_order_num between", value1, value2, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotBetween(String value1, String value2) {
            addCriterion("work_order_num not between", value1, value2, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIsNull() {
            addCriterion("quotation_num is null");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIsNotNull() {
            addCriterion("quotation_num is not null");
            return (Criteria) this;
        }

        public Criteria andQuotationNumEqualTo(String value) {
            addCriterion("quotation_num =", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotEqualTo(String value) {
            addCriterion("quotation_num <>", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumGreaterThan(String value) {
            addCriterion("quotation_num >", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumGreaterThanOrEqualTo(String value) {
            addCriterion("quotation_num >=", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLessThan(String value) {
            addCriterion("quotation_num <", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLessThanOrEqualTo(String value) {
            addCriterion("quotation_num <=", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLike(String value) {
            addCriterion("quotation_num like", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotLike(String value) {
            addCriterion("quotation_num not like", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIn(List<String> values) {
            addCriterion("quotation_num in", values, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotIn(List<String> values) {
            addCriterion("quotation_num not in", values, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumBetween(String value1, String value2) {
            addCriterion("quotation_num between", value1, value2, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotBetween(String value1, String value2) {
            addCriterion("quotation_num not between", value1, value2, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andReportNumIsNull() {
            addCriterion("report_num is null");
            return (Criteria) this;
        }

        public Criteria andReportNumIsNotNull() {
            addCriterion("report_num is not null");
            return (Criteria) this;
        }

        public Criteria andReportNumEqualTo(String value) {
            addCriterion("report_num =", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotEqualTo(String value) {
            addCriterion("report_num <>", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumGreaterThan(String value) {
            addCriterion("report_num >", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumGreaterThanOrEqualTo(String value) {
            addCriterion("report_num >=", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumLessThan(String value) {
            addCriterion("report_num <", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumLessThanOrEqualTo(String value) {
            addCriterion("report_num <=", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumLike(String value) {
            addCriterion("report_num like", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotLike(String value) {
            addCriterion("report_num not like", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumIn(List<String> values) {
            addCriterion("report_num in", values, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotIn(List<String> values) {
            addCriterion("report_num not in", values, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumBetween(String value1, String value2) {
            addCriterion("report_num between", value1, value2, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotBetween(String value1, String value2) {
            addCriterion("report_num not between", value1, value2, "reportNum");
            return (Criteria) this;
        }

        public Criteria andTestComIsNull() {
            addCriterion("test_com is null");
            return (Criteria) this;
        }

        public Criteria andTestComIsNotNull() {
            addCriterion("test_com is not null");
            return (Criteria) this;
        }

        public Criteria andTestComEqualTo(String value) {
            addCriterion("test_com =", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComNotEqualTo(String value) {
            addCriterion("test_com <>", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComGreaterThan(String value) {
            addCriterion("test_com >", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComGreaterThanOrEqualTo(String value) {
            addCriterion("test_com >=", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComLessThan(String value) {
            addCriterion("test_com <", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComLessThanOrEqualTo(String value) {
            addCriterion("test_com <=", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComLike(String value) {
            addCriterion("test_com like", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComNotLike(String value) {
            addCriterion("test_com not like", value, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComIn(List<String> values) {
            addCriterion("test_com in", values, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComNotIn(List<String> values) {
            addCriterion("test_com not in", values, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComBetween(String value1, String value2) {
            addCriterion("test_com between", value1, value2, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComNotBetween(String value1, String value2) {
            addCriterion("test_com not between", value1, value2, "testCom");
            return (Criteria) this;
        }

        public Criteria andTestComIdIsNull() {
            addCriterion("test_com_id is null");
            return (Criteria) this;
        }

        public Criteria andTestComIdIsNotNull() {
            addCriterion("test_com_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestComIdEqualTo(Integer value) {
            addCriterion("test_com_id =", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotEqualTo(Integer value) {
            addCriterion("test_com_id <>", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdGreaterThan(Integer value) {
            addCriterion("test_com_id >", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_com_id >=", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdLessThan(Integer value) {
            addCriterion("test_com_id <", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_com_id <=", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdIn(List<Integer> values) {
            addCriterion("test_com_id in", values, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotIn(List<Integer> values) {
            addCriterion("test_com_id not in", values, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdBetween(Integer value1, Integer value2) {
            addCriterion("test_com_id between", value1, value2, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_com_id not between", value1, value2, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestLabIsNull() {
            addCriterion("test_lab is null");
            return (Criteria) this;
        }

        public Criteria andTestLabIsNotNull() {
            addCriterion("test_lab is not null");
            return (Criteria) this;
        }

        public Criteria andTestLabEqualTo(String value) {
            addCriterion("test_lab =", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabNotEqualTo(String value) {
            addCriterion("test_lab <>", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabGreaterThan(String value) {
            addCriterion("test_lab >", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabGreaterThanOrEqualTo(String value) {
            addCriterion("test_lab >=", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabLessThan(String value) {
            addCriterion("test_lab <", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabLessThanOrEqualTo(String value) {
            addCriterion("test_lab <=", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabLike(String value) {
            addCriterion("test_lab like", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabNotLike(String value) {
            addCriterion("test_lab not like", value, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabIn(List<String> values) {
            addCriterion("test_lab in", values, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabNotIn(List<String> values) {
            addCriterion("test_lab not in", values, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabBetween(String value1, String value2) {
            addCriterion("test_lab between", value1, value2, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabNotBetween(String value1, String value2) {
            addCriterion("test_lab not between", value1, value2, "testLab");
            return (Criteria) this;
        }

        public Criteria andTestLabIdIsNull() {
            addCriterion("test_lab_id is null");
            return (Criteria) this;
        }

        public Criteria andTestLabIdIsNotNull() {
            addCriterion("test_lab_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestLabIdEqualTo(Integer value) {
            addCriterion("test_lab_id =", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdNotEqualTo(Integer value) {
            addCriterion("test_lab_id <>", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdGreaterThan(Integer value) {
            addCriterion("test_lab_id >", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_lab_id >=", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdLessThan(Integer value) {
            addCriterion("test_lab_id <", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_lab_id <=", value, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdIn(List<Integer> values) {
            addCriterion("test_lab_id in", values, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdNotIn(List<Integer> values) {
            addCriterion("test_lab_id not in", values, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdBetween(Integer value1, Integer value2) {
            addCriterion("test_lab_id between", value1, value2, "testLabId");
            return (Criteria) this;
        }

        public Criteria andTestLabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_lab_id not between", value1, value2, "testLabId");
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

        public Criteria andTestDeviceNoIsNull() {
            addCriterion("test_device_no is null");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoIsNotNull() {
            addCriterion("test_device_no is not null");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoEqualTo(String value) {
            addCriterion("test_device_no =", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoNotEqualTo(String value) {
            addCriterion("test_device_no <>", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoGreaterThan(String value) {
            addCriterion("test_device_no >", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("test_device_no >=", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoLessThan(String value) {
            addCriterion("test_device_no <", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("test_device_no <=", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoLike(String value) {
            addCriterion("test_device_no like", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoNotLike(String value) {
            addCriterion("test_device_no not like", value, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoIn(List<String> values) {
            addCriterion("test_device_no in", values, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoNotIn(List<String> values) {
            addCriterion("test_device_no not in", values, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoBetween(String value1, String value2) {
            addCriterion("test_device_no between", value1, value2, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNoNotBetween(String value1, String value2) {
            addCriterion("test_device_no not between", value1, value2, "testDeviceNo");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameIsNull() {
            addCriterion("test_device_name is null");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameIsNotNull() {
            addCriterion("test_device_name is not null");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameEqualTo(String value) {
            addCriterion("test_device_name =", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameNotEqualTo(String value) {
            addCriterion("test_device_name <>", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameGreaterThan(String value) {
            addCriterion("test_device_name >", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("test_device_name >=", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameLessThan(String value) {
            addCriterion("test_device_name <", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("test_device_name <=", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameLike(String value) {
            addCriterion("test_device_name like", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameNotLike(String value) {
            addCriterion("test_device_name not like", value, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameIn(List<String> values) {
            addCriterion("test_device_name in", values, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameNotIn(List<String> values) {
            addCriterion("test_device_name not in", values, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameBetween(String value1, String value2) {
            addCriterion("test_device_name between", value1, value2, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestDeviceNameNotBetween(String value1, String value2) {
            addCriterion("test_device_name not between", value1, value2, "testDeviceName");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdIsNull() {
            addCriterion("test_person_id is null");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdIsNotNull() {
            addCriterion("test_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdEqualTo(Long value) {
            addCriterion("test_person_id =", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdNotEqualTo(Long value) {
            addCriterion("test_person_id <>", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdGreaterThan(Long value) {
            addCriterion("test_person_id >", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_person_id >=", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdLessThan(Long value) {
            addCriterion("test_person_id <", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("test_person_id <=", value, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdIn(List<Long> values) {
            addCriterion("test_person_id in", values, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdNotIn(List<Long> values) {
            addCriterion("test_person_id not in", values, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdBetween(Long value1, Long value2) {
            addCriterion("test_person_id between", value1, value2, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("test_person_id not between", value1, value2, "testPersonId");
            return (Criteria) this;
        }

        public Criteria andTestPersonIsNull() {
            addCriterion("test_person is null");
            return (Criteria) this;
        }

        public Criteria andTestPersonIsNotNull() {
            addCriterion("test_person is not null");
            return (Criteria) this;
        }

        public Criteria andTestPersonEqualTo(String value) {
            addCriterion("test_person =", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotEqualTo(String value) {
            addCriterion("test_person <>", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonGreaterThan(String value) {
            addCriterion("test_person >", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonGreaterThanOrEqualTo(String value) {
            addCriterion("test_person >=", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLessThan(String value) {
            addCriterion("test_person <", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLessThanOrEqualTo(String value) {
            addCriterion("test_person <=", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLike(String value) {
            addCriterion("test_person like", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotLike(String value) {
            addCriterion("test_person not like", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonIn(List<String> values) {
            addCriterion("test_person in", values, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotIn(List<String> values) {
            addCriterion("test_person not in", values, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonBetween(String value1, String value2) {
            addCriterion("test_person between", value1, value2, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotBetween(String value1, String value2) {
            addCriterion("test_person not between", value1, value2, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestMethodIsNull() {
            addCriterion("test_method is null");
            return (Criteria) this;
        }

        public Criteria andTestMethodIsNotNull() {
            addCriterion("test_method is not null");
            return (Criteria) this;
        }

        public Criteria andTestMethodEqualTo(String value) {
            addCriterion("test_method =", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotEqualTo(String value) {
            addCriterion("test_method <>", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodGreaterThan(String value) {
            addCriterion("test_method >", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("test_method >=", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLessThan(String value) {
            addCriterion("test_method <", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLessThanOrEqualTo(String value) {
            addCriterion("test_method <=", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLike(String value) {
            addCriterion("test_method like", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotLike(String value) {
            addCriterion("test_method not like", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodIn(List<String> values) {
            addCriterion("test_method in", values, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotIn(List<String> values) {
            addCriterion("test_method not in", values, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodBetween(String value1, String value2) {
            addCriterion("test_method between", value1, value2, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotBetween(String value1, String value2) {
            addCriterion("test_method not between", value1, value2, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestCaseIsNull() {
            addCriterion("test_case is null");
            return (Criteria) this;
        }

        public Criteria andTestCaseIsNotNull() {
            addCriterion("test_case is not null");
            return (Criteria) this;
        }

        public Criteria andTestCaseEqualTo(String value) {
            addCriterion("test_case =", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotEqualTo(String value) {
            addCriterion("test_case <>", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseGreaterThan(String value) {
            addCriterion("test_case >", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseGreaterThanOrEqualTo(String value) {
            addCriterion("test_case >=", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLessThan(String value) {
            addCriterion("test_case <", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLessThanOrEqualTo(String value) {
            addCriterion("test_case <=", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLike(String value) {
            addCriterion("test_case like", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotLike(String value) {
            addCriterion("test_case not like", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseIn(List<String> values) {
            addCriterion("test_case in", values, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotIn(List<String> values) {
            addCriterion("test_case not in", values, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseBetween(String value1, String value2) {
            addCriterion("test_case between", value1, value2, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotBetween(String value1, String value2) {
            addCriterion("test_case not between", value1, value2, "testCase");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNull() {
            addCriterion("plan_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNotNull() {
            addCriterion("plan_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDateEqualTo(Date value) {
            addCriterion("plan_date =", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotEqualTo(Date value) {
            addCriterion("plan_date <>", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThan(Date value) {
            addCriterion("plan_date >", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_date >=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThan(Date value) {
            addCriterion("plan_date <", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThanOrEqualTo(Date value) {
            addCriterion("plan_date <=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateIn(List<Date> values) {
            addCriterion("plan_date in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotIn(List<Date> values) {
            addCriterion("plan_date not in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateBetween(Date value1, Date value2) {
            addCriterion("plan_date between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotBetween(Date value1, Date value2) {
            addCriterion("plan_date not between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNull() {
            addCriterion("report_date is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("report_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(Date value) {
            addCriterion("report_date =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(Date value) {
            addCriterion("report_date <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(Date value) {
            addCriterion("report_date >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_date >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(Date value) {
            addCriterion("report_date <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(Date value) {
            addCriterion("report_date <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<Date> values) {
            addCriterion("report_date in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<Date> values) {
            addCriterion("report_date not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(Date value1, Date value2) {
            addCriterion("report_date between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(Date value1, Date value2) {
            addCriterion("report_date not between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportPersonIsNull() {
            addCriterion("report_person is null");
            return (Criteria) this;
        }

        public Criteria andReportPersonIsNotNull() {
            addCriterion("report_person is not null");
            return (Criteria) this;
        }

        public Criteria andReportPersonEqualTo(String value) {
            addCriterion("report_person =", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonNotEqualTo(String value) {
            addCriterion("report_person <>", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonGreaterThan(String value) {
            addCriterion("report_person >", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonGreaterThanOrEqualTo(String value) {
            addCriterion("report_person >=", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonLessThan(String value) {
            addCriterion("report_person <", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonLessThanOrEqualTo(String value) {
            addCriterion("report_person <=", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonLike(String value) {
            addCriterion("report_person like", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonNotLike(String value) {
            addCriterion("report_person not like", value, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonIn(List<String> values) {
            addCriterion("report_person in", values, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonNotIn(List<String> values) {
            addCriterion("report_person not in", values, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonBetween(String value1, String value2) {
            addCriterion("report_person between", value1, value2, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonNotBetween(String value1, String value2) {
            addCriterion("report_person not between", value1, value2, "reportPerson");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIsNull() {
            addCriterion("report_person_id is null");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIsNotNull() {
            addCriterion("report_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdEqualTo(Long value) {
            addCriterion("report_person_id =", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotEqualTo(Long value) {
            addCriterion("report_person_id <>", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdGreaterThan(Long value) {
            addCriterion("report_person_id >", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("report_person_id >=", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdLessThan(Long value) {
            addCriterion("report_person_id <", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("report_person_id <=", value, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdIn(List<Long> values) {
            addCriterion("report_person_id in", values, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotIn(List<Long> values) {
            addCriterion("report_person_id not in", values, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdBetween(Long value1, Long value2) {
            addCriterion("report_person_id between", value1, value2, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andReportPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("report_person_id not between", value1, value2, "reportPersonId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNull() {
            addCriterion("test_result is null");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNotNull() {
            addCriterion("test_result is not null");
            return (Criteria) this;
        }

        public Criteria andTestResultEqualTo(String value) {
            addCriterion("test_result =", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotEqualTo(String value) {
            addCriterion("test_result <>", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThan(String value) {
            addCriterion("test_result >", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThanOrEqualTo(String value) {
            addCriterion("test_result >=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThan(String value) {
            addCriterion("test_result <", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThanOrEqualTo(String value) {
            addCriterion("test_result <=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLike(String value) {
            addCriterion("test_result like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotLike(String value) {
            addCriterion("test_result not like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultIn(List<String> values) {
            addCriterion("test_result in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotIn(List<String> values) {
            addCriterion("test_result not in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultBetween(String value1, String value2) {
            addCriterion("test_result between", value1, value2, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotBetween(String value1, String value2) {
            addCriterion("test_result not between", value1, value2, "testResult");
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

        public Criteria andSampleDateIsNull() {
            addCriterion("sample_date is null");
            return (Criteria) this;
        }

        public Criteria andSampleDateIsNotNull() {
            addCriterion("sample_date is not null");
            return (Criteria) this;
        }

        public Criteria andSampleDateEqualTo(Date value) {
            addCriterion("sample_date =", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotEqualTo(Date value) {
            addCriterion("sample_date <>", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateGreaterThan(Date value) {
            addCriterion("sample_date >", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sample_date >=", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateLessThan(Date value) {
            addCriterion("sample_date <", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateLessThanOrEqualTo(Date value) {
            addCriterion("sample_date <=", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateIn(List<Date> values) {
            addCriterion("sample_date in", values, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotIn(List<Date> values) {
            addCriterion("sample_date not in", values, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateBetween(Date value1, Date value2) {
            addCriterion("sample_date between", value1, value2, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotBetween(Date value1, Date value2) {
            addCriterion("sample_date not between", value1, value2, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNull() {
            addCriterion("review_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNotNull() {
            addCriterion("review_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewIdEqualTo(Long value) {
            addCriterion("review_id =", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotEqualTo(Long value) {
            addCriterion("review_id <>", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThan(Long value) {
            addCriterion("review_id >", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThanOrEqualTo(Long value) {
            addCriterion("review_id >=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThan(Long value) {
            addCriterion("review_id <", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThanOrEqualTo(Long value) {
            addCriterion("review_id <=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdIn(List<Long> values) {
            addCriterion("review_id in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotIn(List<Long> values) {
            addCriterion("review_id not in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdBetween(Long value1, Long value2) {
            addCriterion("review_id between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotBetween(Long value1, Long value2) {
            addCriterion("review_id not between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewNameIsNull() {
            addCriterion("review_name is null");
            return (Criteria) this;
        }

        public Criteria andReviewNameIsNotNull() {
            addCriterion("review_name is not null");
            return (Criteria) this;
        }

        public Criteria andReviewNameEqualTo(String value) {
            addCriterion("review_name =", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotEqualTo(String value) {
            addCriterion("review_name <>", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameGreaterThan(String value) {
            addCriterion("review_name >", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameGreaterThanOrEqualTo(String value) {
            addCriterion("review_name >=", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLessThan(String value) {
            addCriterion("review_name <", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLessThanOrEqualTo(String value) {
            addCriterion("review_name <=", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLike(String value) {
            addCriterion("review_name like", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotLike(String value) {
            addCriterion("review_name not like", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameIn(List<String> values) {
            addCriterion("review_name in", values, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotIn(List<String> values) {
            addCriterion("review_name not in", values, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameBetween(String value1, String value2) {
            addCriterion("review_name between", value1, value2, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotBetween(String value1, String value2) {
            addCriterion("review_name not between", value1, value2, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewReasonIsNull() {
            addCriterion("review_reason is null");
            return (Criteria) this;
        }

        public Criteria andReviewReasonIsNotNull() {
            addCriterion("review_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReviewReasonEqualTo(String value) {
            addCriterion("review_reason =", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonNotEqualTo(String value) {
            addCriterion("review_reason <>", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonGreaterThan(String value) {
            addCriterion("review_reason >", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonGreaterThanOrEqualTo(String value) {
            addCriterion("review_reason >=", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonLessThan(String value) {
            addCriterion("review_reason <", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonLessThanOrEqualTo(String value) {
            addCriterion("review_reason <=", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonLike(String value) {
            addCriterion("review_reason like", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonNotLike(String value) {
            addCriterion("review_reason not like", value, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonIn(List<String> values) {
            addCriterion("review_reason in", values, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonNotIn(List<String> values) {
            addCriterion("review_reason not in", values, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonBetween(String value1, String value2) {
            addCriterion("review_reason between", value1, value2, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewReasonNotBetween(String value1, String value2) {
            addCriterion("review_reason not between", value1, value2, "reviewReason");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNull() {
            addCriterion("review_time is null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNotNull() {
            addCriterion("review_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeEqualTo(Date value) {
            addCriterion("review_time =", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotEqualTo(Date value) {
            addCriterion("review_time <>", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThan(Date value) {
            addCriterion("review_time >", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("review_time >=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThan(Date value) {
            addCriterion("review_time <", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("review_time <=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIn(List<Date> values) {
            addCriterion("review_time in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotIn(List<Date> values) {
            addCriterion("review_time not in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeBetween(Date value1, Date value2) {
            addCriterion("review_time between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("review_time not between", value1, value2, "reviewTime");
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