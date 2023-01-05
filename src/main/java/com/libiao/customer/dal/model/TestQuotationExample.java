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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Long value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Long value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Long value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Long value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Long value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Long> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Long> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Long value1, Long value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Long value1, Long value2) {
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

        public Criteria andReportFeeIsNull() {
            addCriterion("report_fee is null");
            return (Criteria) this;
        }

        public Criteria andReportFeeIsNotNull() {
            addCriterion("report_fee is not null");
            return (Criteria) this;
        }

        public Criteria andReportFeeEqualTo(Integer value) {
            addCriterion("report_fee =", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotEqualTo(Integer value) {
            addCriterion("report_fee <>", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeGreaterThan(Integer value) {
            addCriterion("report_fee >", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_fee >=", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeLessThan(Integer value) {
            addCriterion("report_fee <", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeLessThanOrEqualTo(Integer value) {
            addCriterion("report_fee <=", value, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeIn(List<Integer> values) {
            addCriterion("report_fee in", values, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotIn(List<Integer> values) {
            addCriterion("report_fee not in", values, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeBetween(Integer value1, Integer value2) {
            addCriterion("report_fee between", value1, value2, "reportFee");
            return (Criteria) this;
        }

        public Criteria andReportFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_fee not between", value1, value2, "reportFee");
            return (Criteria) this;
        }

        public Criteria andPostageIsNull() {
            addCriterion("postage is null");
            return (Criteria) this;
        }

        public Criteria andPostageIsNotNull() {
            addCriterion("postage is not null");
            return (Criteria) this;
        }

        public Criteria andPostageEqualTo(Integer value) {
            addCriterion("postage =", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotEqualTo(Integer value) {
            addCriterion("postage <>", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThan(Integer value) {
            addCriterion("postage >", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThanOrEqualTo(Integer value) {
            addCriterion("postage >=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThan(Integer value) {
            addCriterion("postage <", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThanOrEqualTo(Integer value) {
            addCriterion("postage <=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageIn(List<Integer> values) {
            addCriterion("postage in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotIn(List<Integer> values) {
            addCriterion("postage not in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageBetween(Integer value1, Integer value2) {
            addCriterion("postage between", value1, value2, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotBetween(Integer value1, Integer value2) {
            addCriterion("postage not between", value1, value2, "postage");
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

        public Criteria andTaxFeeEqualTo(Integer value) {
            addCriterion("tax_fee =", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotEqualTo(Integer value) {
            addCriterion("tax_fee <>", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThan(Integer value) {
            addCriterion("tax_fee >", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tax_fee >=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThan(Integer value) {
            addCriterion("tax_fee <", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeLessThanOrEqualTo(Integer value) {
            addCriterion("tax_fee <=", value, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeIn(List<Integer> values) {
            addCriterion("tax_fee in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotIn(List<Integer> values) {
            addCriterion("tax_fee not in", values, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeBetween(Integer value1, Integer value2) {
            addCriterion("tax_fee between", value1, value2, "taxFee");
            return (Criteria) this;
        }

        public Criteria andTaxFeeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andOrgQuotationNumIsNull() {
            addCriterion("org_quotation_num is null");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumIsNotNull() {
            addCriterion("org_quotation_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumEqualTo(String value) {
            addCriterion("org_quotation_num =", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumNotEqualTo(String value) {
            addCriterion("org_quotation_num <>", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumGreaterThan(String value) {
            addCriterion("org_quotation_num >", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumGreaterThanOrEqualTo(String value) {
            addCriterion("org_quotation_num >=", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumLessThan(String value) {
            addCriterion("org_quotation_num <", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumLessThanOrEqualTo(String value) {
            addCriterion("org_quotation_num <=", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumLike(String value) {
            addCriterion("org_quotation_num like", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumNotLike(String value) {
            addCriterion("org_quotation_num not like", value, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumIn(List<String> values) {
            addCriterion("org_quotation_num in", values, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumNotIn(List<String> values) {
            addCriterion("org_quotation_num not in", values, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumBetween(String value1, String value2) {
            addCriterion("org_quotation_num between", value1, value2, "orgQuotationNum");
            return (Criteria) this;
        }

        public Criteria andOrgQuotationNumNotBetween(String value1, String value2) {
            addCriterion("org_quotation_num not between", value1, value2, "orgQuotationNum");
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