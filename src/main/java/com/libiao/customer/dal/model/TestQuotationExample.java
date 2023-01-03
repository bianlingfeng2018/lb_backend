package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestQuotationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestQuotationExample() {
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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Integer value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Integer value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Integer value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Integer value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Integer value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Integer> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Integer> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Integer value1, Integer value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientNumIsNull() {
            addCriterion("client_num is null");
            return (Criteria) this;
        }

        public Criteria andClientNumIsNotNull() {
            addCriterion("client_num is not null");
            return (Criteria) this;
        }

        public Criteria andClientNumEqualTo(String value) {
            addCriterion("client_num =", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumNotEqualTo(String value) {
            addCriterion("client_num <>", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumGreaterThan(String value) {
            addCriterion("client_num >", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumGreaterThanOrEqualTo(String value) {
            addCriterion("client_num >=", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumLessThan(String value) {
            addCriterion("client_num <", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumLessThanOrEqualTo(String value) {
            addCriterion("client_num <=", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumLike(String value) {
            addCriterion("client_num like", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumNotLike(String value) {
            addCriterion("client_num not like", value, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumIn(List<String> values) {
            addCriterion("client_num in", values, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumNotIn(List<String> values) {
            addCriterion("client_num not in", values, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumBetween(String value1, String value2) {
            addCriterion("client_num between", value1, value2, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNumNotBetween(String value1, String value2) {
            addCriterion("client_num not between", value1, value2, "clientNum");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoIsNull() {
            addCriterion("user_org_no is null");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoIsNotNull() {
            addCriterion("user_org_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoEqualTo(String value) {
            addCriterion("user_org_no =", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoNotEqualTo(String value) {
            addCriterion("user_org_no <>", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoGreaterThan(String value) {
            addCriterion("user_org_no >", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_org_no >=", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoLessThan(String value) {
            addCriterion("user_org_no <", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoLessThanOrEqualTo(String value) {
            addCriterion("user_org_no <=", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoLike(String value) {
            addCriterion("user_org_no like", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoNotLike(String value) {
            addCriterion("user_org_no not like", value, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoIn(List<String> values) {
            addCriterion("user_org_no in", values, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoNotIn(List<String> values) {
            addCriterion("user_org_no not in", values, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoBetween(String value1, String value2) {
            addCriterion("user_org_no between", value1, value2, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andUserOrgNoNotBetween(String value1, String value2) {
            addCriterion("user_org_no not between", value1, value2, "userOrgNo");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Byte value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Byte value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Byte value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Byte value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Byte value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Byte value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Byte> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Byte> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Byte value1, Byte value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Byte value1, Byte value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNull() {
            addCriterion("trade_name is null");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNotNull() {
            addCriterion("trade_name is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNameEqualTo(String value) {
            addCriterion("trade_name =", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotEqualTo(String value) {
            addCriterion("trade_name <>", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThan(String value) {
            addCriterion("trade_name >", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trade_name >=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThan(String value) {
            addCriterion("trade_name <", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThanOrEqualTo(String value) {
            addCriterion("trade_name <=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLike(String value) {
            addCriterion("trade_name like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotLike(String value) {
            addCriterion("trade_name not like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameIn(List<String> values) {
            addCriterion("trade_name in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotIn(List<String> values) {
            addCriterion("trade_name not in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameBetween(String value1, String value2) {
            addCriterion("trade_name between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotBetween(String value1, String value2) {
            addCriterion("trade_name not between", value1, value2, "tradeName");
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

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Byte value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Byte value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Byte value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Byte value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Byte> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Byte> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Byte value1, Byte value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andTradeDescIsNull() {
            addCriterion("trade_desc is null");
            return (Criteria) this;
        }

        public Criteria andTradeDescIsNotNull() {
            addCriterion("trade_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTradeDescEqualTo(String value) {
            addCriterion("trade_desc =", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescNotEqualTo(String value) {
            addCriterion("trade_desc <>", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescGreaterThan(String value) {
            addCriterion("trade_desc >", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescGreaterThanOrEqualTo(String value) {
            addCriterion("trade_desc >=", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescLessThan(String value) {
            addCriterion("trade_desc <", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescLessThanOrEqualTo(String value) {
            addCriterion("trade_desc <=", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescLike(String value) {
            addCriterion("trade_desc like", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescNotLike(String value) {
            addCriterion("trade_desc not like", value, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescIn(List<String> values) {
            addCriterion("trade_desc in", values, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescNotIn(List<String> values) {
            addCriterion("trade_desc not in", values, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescBetween(String value1, String value2) {
            addCriterion("trade_desc between", value1, value2, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andTradeDescNotBetween(String value1, String value2) {
            addCriterion("trade_desc not between", value1, value2, "tradeDesc");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Byte value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Byte value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Byte value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Byte value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Byte value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Byte> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Byte> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Byte value1, Byte value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andAttnIsNull() {
            addCriterion("attn is null");
            return (Criteria) this;
        }

        public Criteria andAttnIsNotNull() {
            addCriterion("attn is not null");
            return (Criteria) this;
        }

        public Criteria andAttnEqualTo(String value) {
            addCriterion("attn =", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotEqualTo(String value) {
            addCriterion("attn <>", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnGreaterThan(String value) {
            addCriterion("attn >", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnGreaterThanOrEqualTo(String value) {
            addCriterion("attn >=", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLessThan(String value) {
            addCriterion("attn <", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLessThanOrEqualTo(String value) {
            addCriterion("attn <=", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnLike(String value) {
            addCriterion("attn like", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotLike(String value) {
            addCriterion("attn not like", value, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnIn(List<String> values) {
            addCriterion("attn in", values, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotIn(List<String> values) {
            addCriterion("attn not in", values, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnBetween(String value1, String value2) {
            addCriterion("attn between", value1, value2, "attn");
            return (Criteria) this;
        }

        public Criteria andAttnNotBetween(String value1, String value2) {
            addCriterion("attn not between", value1, value2, "attn");
            return (Criteria) this;
        }

        public Criteria andTelClientIsNull() {
            addCriterion("tel_client is null");
            return (Criteria) this;
        }

        public Criteria andTelClientIsNotNull() {
            addCriterion("tel_client is not null");
            return (Criteria) this;
        }

        public Criteria andTelClientEqualTo(String value) {
            addCriterion("tel_client =", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientNotEqualTo(String value) {
            addCriterion("tel_client <>", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientGreaterThan(String value) {
            addCriterion("tel_client >", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientGreaterThanOrEqualTo(String value) {
            addCriterion("tel_client >=", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientLessThan(String value) {
            addCriterion("tel_client <", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientLessThanOrEqualTo(String value) {
            addCriterion("tel_client <=", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientLike(String value) {
            addCriterion("tel_client like", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientNotLike(String value) {
            addCriterion("tel_client not like", value, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientIn(List<String> values) {
            addCriterion("tel_client in", values, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientNotIn(List<String> values) {
            addCriterion("tel_client not in", values, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientBetween(String value1, String value2) {
            addCriterion("tel_client between", value1, value2, "telClient");
            return (Criteria) this;
        }

        public Criteria andTelClientNotBetween(String value1, String value2) {
            addCriterion("tel_client not between", value1, value2, "telClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientIsNull() {
            addCriterion("fax_client is null");
            return (Criteria) this;
        }

        public Criteria andFaxClientIsNotNull() {
            addCriterion("fax_client is not null");
            return (Criteria) this;
        }

        public Criteria andFaxClientEqualTo(String value) {
            addCriterion("fax_client =", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientNotEqualTo(String value) {
            addCriterion("fax_client <>", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientGreaterThan(String value) {
            addCriterion("fax_client >", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientGreaterThanOrEqualTo(String value) {
            addCriterion("fax_client >=", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientLessThan(String value) {
            addCriterion("fax_client <", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientLessThanOrEqualTo(String value) {
            addCriterion("fax_client <=", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientLike(String value) {
            addCriterion("fax_client like", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientNotLike(String value) {
            addCriterion("fax_client not like", value, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientIn(List<String> values) {
            addCriterion("fax_client in", values, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientNotIn(List<String> values) {
            addCriterion("fax_client not in", values, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientBetween(String value1, String value2) {
            addCriterion("fax_client between", value1, value2, "faxClient");
            return (Criteria) this;
        }

        public Criteria andFaxClientNotBetween(String value1, String value2) {
            addCriterion("fax_client not between", value1, value2, "faxClient");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("delivery_address is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("delivery_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("delivery_address =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("delivery_address <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("delivery_address >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_address >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("delivery_address <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("delivery_address <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("delivery_address like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("delivery_address not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("delivery_address in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("delivery_address not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("delivery_address between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("delivery_address not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNull() {
            addCriterion("bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNotNull() {
            addCriterion("bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameEqualTo(String value) {
            addCriterion("bank_account_name =", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotEqualTo(String value) {
            addCriterion("bank_account_name <>", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThan(String value) {
            addCriterion("bank_account_name >", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_name >=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThan(String value) {
            addCriterion("bank_account_name <", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("bank_account_name <=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLike(String value) {
            addCriterion("bank_account_name like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotLike(String value) {
            addCriterion("bank_account_name not like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIn(List<String> values) {
            addCriterion("bank_account_name in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotIn(List<String> values) {
            addCriterion("bank_account_name not in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameBetween(String value1, String value2) {
            addCriterion("bank_account_name between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("bank_account_name not between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureIsNull() {
            addCriterion("client_com_signature is null");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureIsNotNull() {
            addCriterion("client_com_signature is not null");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureEqualTo(String value) {
            addCriterion("client_com_signature =", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureNotEqualTo(String value) {
            addCriterion("client_com_signature <>", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureGreaterThan(String value) {
            addCriterion("client_com_signature >", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("client_com_signature >=", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureLessThan(String value) {
            addCriterion("client_com_signature <", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureLessThanOrEqualTo(String value) {
            addCriterion("client_com_signature <=", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureLike(String value) {
            addCriterion("client_com_signature like", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureNotLike(String value) {
            addCriterion("client_com_signature not like", value, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureIn(List<String> values) {
            addCriterion("client_com_signature in", values, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureNotIn(List<String> values) {
            addCriterion("client_com_signature not in", values, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureBetween(String value1, String value2) {
            addCriterion("client_com_signature between", value1, value2, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andClientComSignatureNotBetween(String value1, String value2) {
            addCriterion("client_com_signature not between", value1, value2, "clientComSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureIsNull() {
            addCriterion("libiao_representative_signature is null");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureIsNotNull() {
            addCriterion("libiao_representative_signature is not null");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureEqualTo(String value) {
            addCriterion("libiao_representative_signature =", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureNotEqualTo(String value) {
            addCriterion("libiao_representative_signature <>", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureGreaterThan(String value) {
            addCriterion("libiao_representative_signature >", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("libiao_representative_signature >=", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureLessThan(String value) {
            addCriterion("libiao_representative_signature <", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureLessThanOrEqualTo(String value) {
            addCriterion("libiao_representative_signature <=", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureLike(String value) {
            addCriterion("libiao_representative_signature like", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureNotLike(String value) {
            addCriterion("libiao_representative_signature not like", value, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureIn(List<String> values) {
            addCriterion("libiao_representative_signature in", values, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureNotIn(List<String> values) {
            addCriterion("libiao_representative_signature not in", values, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureBetween(String value1, String value2) {
            addCriterion("libiao_representative_signature between", value1, value2, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andLibiaoRepresentativeSignatureNotBetween(String value1, String value2) {
            addCriterion("libiao_representative_signature not between", value1, value2, "libiaoRepresentativeSignature");
            return (Criteria) this;
        }

        public Criteria andClientComChopIsNull() {
            addCriterion("client_com_chop is null");
            return (Criteria) this;
        }

        public Criteria andClientComChopIsNotNull() {
            addCriterion("client_com_chop is not null");
            return (Criteria) this;
        }

        public Criteria andClientComChopEqualTo(String value) {
            addCriterion("client_com_chop =", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopNotEqualTo(String value) {
            addCriterion("client_com_chop <>", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopGreaterThan(String value) {
            addCriterion("client_com_chop >", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopGreaterThanOrEqualTo(String value) {
            addCriterion("client_com_chop >=", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopLessThan(String value) {
            addCriterion("client_com_chop <", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopLessThanOrEqualTo(String value) {
            addCriterion("client_com_chop <=", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopLike(String value) {
            addCriterion("client_com_chop like", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopNotLike(String value) {
            addCriterion("client_com_chop not like", value, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopIn(List<String> values) {
            addCriterion("client_com_chop in", values, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopNotIn(List<String> values) {
            addCriterion("client_com_chop not in", values, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopBetween(String value1, String value2) {
            addCriterion("client_com_chop between", value1, value2, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andClientComChopNotBetween(String value1, String value2) {
            addCriterion("client_com_chop not between", value1, value2, "clientComChop");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(String value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(String value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(String value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(String value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(String value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(String value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLike(String value) {
            addCriterion("audit like", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotLike(String value) {
            addCriterion("audit not like", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<String> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<String> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(String value1, String value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(String value1, String value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateIsNull() {
            addCriterion("client_signature_date is null");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateIsNotNull() {
            addCriterion("client_signature_date is not null");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateEqualTo(String value) {
            addCriterion("client_signature_date =", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateNotEqualTo(String value) {
            addCriterion("client_signature_date <>", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateGreaterThan(String value) {
            addCriterion("client_signature_date >", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateGreaterThanOrEqualTo(String value) {
            addCriterion("client_signature_date >=", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateLessThan(String value) {
            addCriterion("client_signature_date <", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateLessThanOrEqualTo(String value) {
            addCriterion("client_signature_date <=", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateLike(String value) {
            addCriterion("client_signature_date like", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateNotLike(String value) {
            addCriterion("client_signature_date not like", value, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateIn(List<String> values) {
            addCriterion("client_signature_date in", values, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateNotIn(List<String> values) {
            addCriterion("client_signature_date not in", values, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateBetween(String value1, String value2) {
            addCriterion("client_signature_date between", value1, value2, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andClientSignatureDateNotBetween(String value1, String value2) {
            addCriterion("client_signature_date not between", value1, value2, "clientSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateIsNull() {
            addCriterion("libiao_signature_date is null");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateIsNotNull() {
            addCriterion("libiao_signature_date is not null");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateEqualTo(String value) {
            addCriterion("libiao_signature_date =", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateNotEqualTo(String value) {
            addCriterion("libiao_signature_date <>", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateGreaterThan(String value) {
            addCriterion("libiao_signature_date >", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateGreaterThanOrEqualTo(String value) {
            addCriterion("libiao_signature_date >=", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateLessThan(String value) {
            addCriterion("libiao_signature_date <", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateLessThanOrEqualTo(String value) {
            addCriterion("libiao_signature_date <=", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateLike(String value) {
            addCriterion("libiao_signature_date like", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateNotLike(String value) {
            addCriterion("libiao_signature_date not like", value, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateIn(List<String> values) {
            addCriterion("libiao_signature_date in", values, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateNotIn(List<String> values) {
            addCriterion("libiao_signature_date not in", values, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateBetween(String value1, String value2) {
            addCriterion("libiao_signature_date between", value1, value2, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andLibiaoSignatureDateNotBetween(String value1, String value2) {
            addCriterion("libiao_signature_date not between", value1, value2, "libiaoSignatureDate");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdIsNull() {
            addCriterion("test_trade_id is null");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdIsNotNull() {
            addCriterion("test_trade_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdEqualTo(Long value) {
            addCriterion("test_trade_id =", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdNotEqualTo(Long value) {
            addCriterion("test_trade_id <>", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdGreaterThan(Long value) {
            addCriterion("test_trade_id >", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_trade_id >=", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdLessThan(Long value) {
            addCriterion("test_trade_id <", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdLessThanOrEqualTo(Long value) {
            addCriterion("test_trade_id <=", value, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdIn(List<Long> values) {
            addCriterion("test_trade_id in", values, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdNotIn(List<Long> values) {
            addCriterion("test_trade_id not in", values, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdBetween(Long value1, Long value2) {
            addCriterion("test_trade_id between", value1, value2, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andTestTradeIdNotBetween(Long value1, Long value2) {
            addCriterion("test_trade_id not between", value1, value2, "testTradeId");
            return (Criteria) this;
        }

        public Criteria andFromComIsNull() {
            addCriterion("from_com is null");
            return (Criteria) this;
        }

        public Criteria andFromComIsNotNull() {
            addCriterion("from_com is not null");
            return (Criteria) this;
        }

        public Criteria andFromComEqualTo(String value) {
            addCriterion("from_com =", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComNotEqualTo(String value) {
            addCriterion("from_com <>", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComGreaterThan(String value) {
            addCriterion("from_com >", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComGreaterThanOrEqualTo(String value) {
            addCriterion("from_com >=", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComLessThan(String value) {
            addCriterion("from_com <", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComLessThanOrEqualTo(String value) {
            addCriterion("from_com <=", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComLike(String value) {
            addCriterion("from_com like", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComNotLike(String value) {
            addCriterion("from_com not like", value, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComIn(List<String> values) {
            addCriterion("from_com in", values, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComNotIn(List<String> values) {
            addCriterion("from_com not in", values, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComBetween(String value1, String value2) {
            addCriterion("from_com between", value1, value2, "fromCom");
            return (Criteria) this;
        }

        public Criteria andFromComNotBetween(String value1, String value2) {
            addCriterion("from_com not between", value1, value2, "fromCom");
            return (Criteria) this;
        }

        public Criteria andReportFeeIsNull() {
            addCriterion("report_fee is null");
            return (Criteria) this;
        }

        public Criteria andReportFeeIsNotNull() {
            addCriterion("report_fee is not null");
            return (Criteria) this;
        }

        public Criteria andReportFeeEqualTo(String value) {
            addCriterion("report_fee =", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotEqualTo(String value) {
            addCriterion("report_fee <>", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeGreaterThan(String value) {
            addCriterion("report_fee >", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeGreaterThanOrEqualTo(String value) {
            addCriterion("report_fee >=", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeLessThan(String value) {
            addCriterion("report_fee <", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeLessThanOrEqualTo(String value) {
            addCriterion("report_fee <=", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeLike(String value) {
            addCriterion("report_fee like", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotLike(String value) {
            addCriterion("report_fee not like", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeIn(List<String> values) {
            addCriterion("report_fee in", values, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotIn(List<String> values) {
            addCriterion("report_fee not in", values, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeBetween(String value1, String value2) {
            addCriterion("report_fee between", value1, value2, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotBetween(String value1, String value2) {
            addCriterion("report_fee not between", value1, value2, "reportFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeIsNull() {
            addCriterion("courier_fee is null");
            return (Criteria) this;
        }

        public Criteria andCourierFeeIsNotNull() {
            addCriterion("courier_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCourierFeeEqualTo(String value) {
            addCriterion("courier_fee =", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeNotEqualTo(String value) {
            addCriterion("courier_fee <>", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeGreaterThan(String value) {
            addCriterion("courier_fee >", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeGreaterThanOrEqualTo(String value) {
            addCriterion("courier_fee >=", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeLessThan(String value) {
            addCriterion("courier_fee <", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeLessThanOrEqualTo(String value) {
            addCriterion("courier_fee <=", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeLike(String value) {
            addCriterion("courier_fee like", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeNotLike(String value) {
            addCriterion("courier_fee not like", value, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeIn(List<String> values) {
            addCriterion("courier_fee in", values, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeNotIn(List<String> values) {
            addCriterion("courier_fee not in", values, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeBetween(String value1, String value2) {
            addCriterion("courier_fee between", value1, value2, "courierFee");
            return (Criteria) this;
        }

        public Criteria andCourierFeeNotBetween(String value1, String value2) {
            addCriterion("courier_fee not between", value1, value2, "courierFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIsNull() {
            addCriterion("tax_fee is null");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIsNotNull() {
            addCriterion("tax_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTaxFeeEqualTo(String value) {
            addCriterion("tax_fee =", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotEqualTo(String value) {
            addCriterion("tax_fee <>", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThan(String value) {
            addCriterion("tax_fee >", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThanOrEqualTo(String value) {
            addCriterion("tax_fee >=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThan(String value) {
            addCriterion("tax_fee <", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThanOrEqualTo(String value) {
            addCriterion("tax_fee <=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLike(String value) {
            addCriterion("tax_fee like", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotLike(String value) {
            addCriterion("tax_fee not like", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIn(List<String> values) {
            addCriterion("tax_fee in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotIn(List<String> values) {
            addCriterion("tax_fee not in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeBetween(String value1, String value2) {
            addCriterion("tax_fee between", value1, value2, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotBetween(String value1, String value2) {
            addCriterion("tax_fee not between", value1, value2, "taxFee");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("discount like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("discount not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNull() {
            addCriterion("total_cost is null");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNotNull() {
            addCriterion("total_cost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCostEqualTo(Integer value) {
            addCriterion("total_cost =", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotEqualTo(Integer value) {
            addCriterion("total_cost <>", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThan(Integer value) {
            addCriterion("total_cost >", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_cost >=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThan(Integer value) {
            addCriterion("total_cost <", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThanOrEqualTo(Integer value) {
            addCriterion("total_cost <=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostIn(List<Integer> values) {
            addCriterion("total_cost in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotIn(List<Integer> values) {
            addCriterion("total_cost not in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostBetween(Integer value1, Integer value2) {
            addCriterion("total_cost between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotBetween(Integer value1, Integer value2) {
            addCriterion("total_cost not between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtIsNull() {
            addCriterion("total_test_amt is null");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtIsNotNull() {
            addCriterion("total_test_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtEqualTo(Integer value) {
            addCriterion("total_test_amt =", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtNotEqualTo(Integer value) {
            addCriterion("total_test_amt <>", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtGreaterThan(Integer value) {
            addCriterion("total_test_amt >", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_test_amt >=", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtLessThan(Integer value) {
            addCriterion("total_test_amt <", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtLessThanOrEqualTo(Integer value) {
            addCriterion("total_test_amt <=", value, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtIn(List<Integer> values) {
            addCriterion("total_test_amt in", values, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtNotIn(List<Integer> values) {
            addCriterion("total_test_amt not in", values, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtBetween(Integer value1, Integer value2) {
            addCriterion("total_test_amt between", value1, value2, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTestAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("total_test_amt not between", value1, value2, "totalTestAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtIsNull() {
            addCriterion("paid_amt is null");
            return (Criteria) this;
        }

        public Criteria andPaidAmtIsNotNull() {
            addCriterion("paid_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPaidAmtEqualTo(Integer value) {
            addCriterion("paid_amt =", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtNotEqualTo(Integer value) {
            addCriterion("paid_amt <>", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtGreaterThan(Integer value) {
            addCriterion("paid_amt >", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("paid_amt >=", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtLessThan(Integer value) {
            addCriterion("paid_amt <", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtLessThanOrEqualTo(Integer value) {
            addCriterion("paid_amt <=", value, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtIn(List<Integer> values) {
            addCriterion("paid_amt in", values, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtNotIn(List<Integer> values) {
            addCriterion("paid_amt not in", values, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtBetween(Integer value1, Integer value2) {
            addCriterion("paid_amt between", value1, value2, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andPaidAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("paid_amt not between", value1, value2, "paidAmt");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Long value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Long value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Long> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSingleReportIsNull() {
            addCriterion("single_report is null");
            return (Criteria) this;
        }

        public Criteria andSingleReportIsNotNull() {
            addCriterion("single_report is not null");
            return (Criteria) this;
        }

        public Criteria andSingleReportEqualTo(Byte value) {
            addCriterion("single_report =", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportNotEqualTo(Byte value) {
            addCriterion("single_report <>", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportGreaterThan(Byte value) {
            addCriterion("single_report >", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportGreaterThanOrEqualTo(Byte value) {
            addCriterion("single_report >=", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportLessThan(Byte value) {
            addCriterion("single_report <", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportLessThanOrEqualTo(Byte value) {
            addCriterion("single_report <=", value, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportIn(List<Byte> values) {
            addCriterion("single_report in", values, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportNotIn(List<Byte> values) {
            addCriterion("single_report not in", values, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportBetween(Byte value1, Byte value2) {
            addCriterion("single_report between", value1, value2, "singleReport");
            return (Criteria) this;
        }

        public Criteria andSingleReportNotBetween(Byte value1, Byte value2) {
            addCriterion("single_report not between", value1, value2, "singleReport");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumIsNull() {
            addCriterion("orgQuotationNum is null");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumIsNotNull() {
            addCriterion("orgQuotationNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumEqualTo(String value) {
            addCriterion("orgQuotationNum =", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumNotEqualTo(String value) {
            addCriterion("orgQuotationNum <>", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumGreaterThan(String value) {
            addCriterion("orgQuotationNum >", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumGreaterThanOrEqualTo(String value) {
            addCriterion("orgQuotationNum >=", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumLessThan(String value) {
            addCriterion("orgQuotationNum <", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumLessThanOrEqualTo(String value) {
            addCriterion("orgQuotationNum <=", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumLike(String value) {
            addCriterion("orgQuotationNum like", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumNotLike(String value) {
            addCriterion("orgQuotationNum not like", value, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumIn(List<String> values) {
            addCriterion("orgQuotationNum in", values, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumNotIn(List<String> values) {
            addCriterion("orgQuotationNum not in", values, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumBetween(String value1, String value2) {
            addCriterion("orgQuotationNum between", value1, value2, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andOrgquotationnumNotBetween(String value1, String value2) {
            addCriterion("orgQuotationNum not between", value1, value2, "orgquotationnum");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNull() {
            addCriterion("audit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(Long value) {
            addCriterion("audit_id =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(Long value) {
            addCriterion("audit_id <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(Long value) {
            addCriterion("audit_id >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_id >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(Long value) {
            addCriterion("audit_id <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_id <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<Long> values) {
            addCriterion("audit_id in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<Long> values) {
            addCriterion("audit_id not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(Long value1, Long value2) {
            addCriterion("audit_id between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_id not between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNull() {
            addCriterion("audit_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNotNull() {
            addCriterion("audit_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNameEqualTo(String value) {
            addCriterion("audit_name =", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotEqualTo(String value) {
            addCriterion("audit_name <>", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThan(String value) {
            addCriterion("audit_name >", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_name >=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThan(String value) {
            addCriterion("audit_name <", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThanOrEqualTo(String value) {
            addCriterion("audit_name <=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLike(String value) {
            addCriterion("audit_name like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotLike(String value) {
            addCriterion("audit_name not like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameIn(List<String> values) {
            addCriterion("audit_name in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotIn(List<String> values) {
            addCriterion("audit_name not in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameBetween(String value1, String value2) {
            addCriterion("audit_name between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotBetween(String value1, String value2) {
            addCriterion("audit_name not between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNull() {
            addCriterion("audit_reason is null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNotNull() {
            addCriterion("audit_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonEqualTo(String value) {
            addCriterion("audit_reason =", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotEqualTo(String value) {
            addCriterion("audit_reason <>", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThan(String value) {
            addCriterion("audit_reason >", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThanOrEqualTo(String value) {
            addCriterion("audit_reason >=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThan(String value) {
            addCriterion("audit_reason <", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThanOrEqualTo(String value) {
            addCriterion("audit_reason <=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLike(String value) {
            addCriterion("audit_reason like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotLike(String value) {
            addCriterion("audit_reason not like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIn(List<String> values) {
            addCriterion("audit_reason in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotIn(List<String> values) {
            addCriterion("audit_reason not in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonBetween(String value1, String value2) {
            addCriterion("audit_reason between", value1, value2, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotBetween(String value1, String value2) {
            addCriterion("audit_reason not between", value1, value2, "auditReason");
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