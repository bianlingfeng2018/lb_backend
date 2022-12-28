package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNull() {
            addCriterion("abbr is null");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNotNull() {
            addCriterion("abbr is not null");
            return (Criteria) this;
        }

        public Criteria andAbbrEqualTo(String value) {
            addCriterion("abbr =", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotEqualTo(String value) {
            addCriterion("abbr <>", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThan(String value) {
            addCriterion("abbr >", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("abbr >=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThan(String value) {
            addCriterion("abbr <", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThanOrEqualTo(String value) {
            addCriterion("abbr <=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLike(String value) {
            addCriterion("abbr like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotLike(String value) {
            addCriterion("abbr not like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrIn(List<String> values) {
            addCriterion("abbr in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotIn(List<String> values) {
            addCriterion("abbr not in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrBetween(String value1, String value2) {
            addCriterion("abbr between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotBetween(String value1, String value2) {
            addCriterion("abbr not between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameIsNull() {
            addCriterion("invoice_name is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameIsNotNull() {
            addCriterion("invoice_name is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameEqualTo(String value) {
            addCriterion("invoice_name =", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameNotEqualTo(String value) {
            addCriterion("invoice_name <>", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameGreaterThan(String value) {
            addCriterion("invoice_name >", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_name >=", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameLessThan(String value) {
            addCriterion("invoice_name <", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameLessThanOrEqualTo(String value) {
            addCriterion("invoice_name <=", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameLike(String value) {
            addCriterion("invoice_name like", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameNotLike(String value) {
            addCriterion("invoice_name not like", value, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameIn(List<String> values) {
            addCriterion("invoice_name in", values, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameNotIn(List<String> values) {
            addCriterion("invoice_name not in", values, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameBetween(String value1, String value2) {
            addCriterion("invoice_name between", value1, value2, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNameNotBetween(String value1, String value2) {
            addCriterion("invoice_name not between", value1, value2, "invoiceName");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumIsNull() {
            addCriterion("invoice_tax_num is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumIsNotNull() {
            addCriterion("invoice_tax_num is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumEqualTo(String value) {
            addCriterion("invoice_tax_num =", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumNotEqualTo(String value) {
            addCriterion("invoice_tax_num <>", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumGreaterThan(String value) {
            addCriterion("invoice_tax_num >", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_tax_num >=", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumLessThan(String value) {
            addCriterion("invoice_tax_num <", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumLessThanOrEqualTo(String value) {
            addCriterion("invoice_tax_num <=", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumLike(String value) {
            addCriterion("invoice_tax_num like", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumNotLike(String value) {
            addCriterion("invoice_tax_num not like", value, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumIn(List<String> values) {
            addCriterion("invoice_tax_num in", values, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumNotIn(List<String> values) {
            addCriterion("invoice_tax_num not in", values, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumBetween(String value1, String value2) {
            addCriterion("invoice_tax_num between", value1, value2, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceTaxNumNotBetween(String value1, String value2) {
            addCriterion("invoice_tax_num not between", value1, value2, "invoiceTaxNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrIsNull() {
            addCriterion("invoice_addr is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrIsNotNull() {
            addCriterion("invoice_addr is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrEqualTo(String value) {
            addCriterion("invoice_addr =", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrNotEqualTo(String value) {
            addCriterion("invoice_addr <>", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrGreaterThan(String value) {
            addCriterion("invoice_addr >", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_addr >=", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrLessThan(String value) {
            addCriterion("invoice_addr <", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrLessThanOrEqualTo(String value) {
            addCriterion("invoice_addr <=", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrLike(String value) {
            addCriterion("invoice_addr like", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrNotLike(String value) {
            addCriterion("invoice_addr not like", value, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrIn(List<String> values) {
            addCriterion("invoice_addr in", values, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrNotIn(List<String> values) {
            addCriterion("invoice_addr not in", values, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrBetween(String value1, String value2) {
            addCriterion("invoice_addr between", value1, value2, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddrNotBetween(String value1, String value2) {
            addCriterion("invoice_addr not between", value1, value2, "invoiceAddr");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelIsNull() {
            addCriterion("invoice_tel is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelIsNotNull() {
            addCriterion("invoice_tel is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelEqualTo(String value) {
            addCriterion("invoice_tel =", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelNotEqualTo(String value) {
            addCriterion("invoice_tel <>", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelGreaterThan(String value) {
            addCriterion("invoice_tel >", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_tel >=", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelLessThan(String value) {
            addCriterion("invoice_tel <", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelLessThanOrEqualTo(String value) {
            addCriterion("invoice_tel <=", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelLike(String value) {
            addCriterion("invoice_tel like", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelNotLike(String value) {
            addCriterion("invoice_tel not like", value, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelIn(List<String> values) {
            addCriterion("invoice_tel in", values, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelNotIn(List<String> values) {
            addCriterion("invoice_tel not in", values, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelBetween(String value1, String value2) {
            addCriterion("invoice_tel between", value1, value2, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceTelNotBetween(String value1, String value2) {
            addCriterion("invoice_tel not between", value1, value2, "invoiceTel");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankIsNull() {
            addCriterion("invoice_bank is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankIsNotNull() {
            addCriterion("invoice_bank is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankEqualTo(String value) {
            addCriterion("invoice_bank =", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankNotEqualTo(String value) {
            addCriterion("invoice_bank <>", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankGreaterThan(String value) {
            addCriterion("invoice_bank >", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_bank >=", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankLessThan(String value) {
            addCriterion("invoice_bank <", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankLessThanOrEqualTo(String value) {
            addCriterion("invoice_bank <=", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankLike(String value) {
            addCriterion("invoice_bank like", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankNotLike(String value) {
            addCriterion("invoice_bank not like", value, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankIn(List<String> values) {
            addCriterion("invoice_bank in", values, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankNotIn(List<String> values) {
            addCriterion("invoice_bank not in", values, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankBetween(String value1, String value2) {
            addCriterion("invoice_bank between", value1, value2, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceBankNotBetween(String value1, String value2) {
            addCriterion("invoice_bank not between", value1, value2, "invoiceBank");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccIsNull() {
            addCriterion("invoice_acc is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccIsNotNull() {
            addCriterion("invoice_acc is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccEqualTo(String value) {
            addCriterion("invoice_acc =", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccNotEqualTo(String value) {
            addCriterion("invoice_acc <>", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccGreaterThan(String value) {
            addCriterion("invoice_acc >", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_acc >=", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccLessThan(String value) {
            addCriterion("invoice_acc <", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccLessThanOrEqualTo(String value) {
            addCriterion("invoice_acc <=", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccLike(String value) {
            addCriterion("invoice_acc like", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccNotLike(String value) {
            addCriterion("invoice_acc not like", value, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccIn(List<String> values) {
            addCriterion("invoice_acc in", values, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccNotIn(List<String> values) {
            addCriterion("invoice_acc not in", values, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccBetween(String value1, String value2) {
            addCriterion("invoice_acc between", value1, value2, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceAccNotBetween(String value1, String value2) {
            addCriterion("invoice_acc not between", value1, value2, "invoiceAcc");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecIsNull() {
            addCriterion("invoice_is_spec is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecIsNotNull() {
            addCriterion("invoice_is_spec is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecEqualTo(String value) {
            addCriterion("invoice_is_spec =", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecNotEqualTo(String value) {
            addCriterion("invoice_is_spec <>", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecGreaterThan(String value) {
            addCriterion("invoice_is_spec >", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_is_spec >=", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecLessThan(String value) {
            addCriterion("invoice_is_spec <", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecLessThanOrEqualTo(String value) {
            addCriterion("invoice_is_spec <=", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecLike(String value) {
            addCriterion("invoice_is_spec like", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecNotLike(String value) {
            addCriterion("invoice_is_spec not like", value, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecIn(List<String> values) {
            addCriterion("invoice_is_spec in", values, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecNotIn(List<String> values) {
            addCriterion("invoice_is_spec not in", values, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecBetween(String value1, String value2) {
            addCriterion("invoice_is_spec between", value1, value2, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsSpecNotBetween(String value1, String value2) {
            addCriterion("invoice_is_spec not between", value1, value2, "invoiceIsSpec");
            return (Criteria) this;
        }

        public Criteria andClientClassIsNull() {
            addCriterion("client_class is null");
            return (Criteria) this;
        }

        public Criteria andClientClassIsNotNull() {
            addCriterion("client_class is not null");
            return (Criteria) this;
        }

        public Criteria andClientClassEqualTo(String value) {
            addCriterion("client_class =", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassNotEqualTo(String value) {
            addCriterion("client_class <>", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassGreaterThan(String value) {
            addCriterion("client_class >", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassGreaterThanOrEqualTo(String value) {
            addCriterion("client_class >=", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassLessThan(String value) {
            addCriterion("client_class <", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassLessThanOrEqualTo(String value) {
            addCriterion("client_class <=", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassLike(String value) {
            addCriterion("client_class like", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassNotLike(String value) {
            addCriterion("client_class not like", value, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassIn(List<String> values) {
            addCriterion("client_class in", values, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassNotIn(List<String> values) {
            addCriterion("client_class not in", values, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassBetween(String value1, String value2) {
            addCriterion("client_class between", value1, value2, "clientClass");
            return (Criteria) this;
        }

        public Criteria andClientClassNotBetween(String value1, String value2) {
            addCriterion("client_class not between", value1, value2, "clientClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassIsNull() {
            addCriterion("indust_class is null");
            return (Criteria) this;
        }

        public Criteria andIndustClassIsNotNull() {
            addCriterion("indust_class is not null");
            return (Criteria) this;
        }

        public Criteria andIndustClassEqualTo(String value) {
            addCriterion("indust_class =", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassNotEqualTo(String value) {
            addCriterion("indust_class <>", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassGreaterThan(String value) {
            addCriterion("indust_class >", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassGreaterThanOrEqualTo(String value) {
            addCriterion("indust_class >=", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassLessThan(String value) {
            addCriterion("indust_class <", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassLessThanOrEqualTo(String value) {
            addCriterion("indust_class <=", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassLike(String value) {
            addCriterion("indust_class like", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassNotLike(String value) {
            addCriterion("indust_class not like", value, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassIn(List<String> values) {
            addCriterion("indust_class in", values, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassNotIn(List<String> values) {
            addCriterion("indust_class not in", values, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassBetween(String value1, String value2) {
            addCriterion("indust_class between", value1, value2, "industClass");
            return (Criteria) this;
        }

        public Criteria andIndustClassNotBetween(String value1, String value2) {
            addCriterion("indust_class not between", value1, value2, "industClass");
            return (Criteria) this;
        }

        public Criteria andClientLevelIsNull() {
            addCriterion("client_level is null");
            return (Criteria) this;
        }

        public Criteria andClientLevelIsNotNull() {
            addCriterion("client_level is not null");
            return (Criteria) this;
        }

        public Criteria andClientLevelEqualTo(String value) {
            addCriterion("client_level =", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelNotEqualTo(String value) {
            addCriterion("client_level <>", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelGreaterThan(String value) {
            addCriterion("client_level >", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelGreaterThanOrEqualTo(String value) {
            addCriterion("client_level >=", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelLessThan(String value) {
            addCriterion("client_level <", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelLessThanOrEqualTo(String value) {
            addCriterion("client_level <=", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelLike(String value) {
            addCriterion("client_level like", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelNotLike(String value) {
            addCriterion("client_level not like", value, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelIn(List<String> values) {
            addCriterion("client_level in", values, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelNotIn(List<String> values) {
            addCriterion("client_level not in", values, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelBetween(String value1, String value2) {
            addCriterion("client_level between", value1, value2, "clientLevel");
            return (Criteria) this;
        }

        public Criteria andClientLevelNotBetween(String value1, String value2) {
            addCriterion("client_level not between", value1, value2, "clientLevel");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOppNumbIsNull() {
            addCriterion("opp_numb is null");
            return (Criteria) this;
        }

        public Criteria andOppNumbIsNotNull() {
            addCriterion("opp_numb is not null");
            return (Criteria) this;
        }

        public Criteria andOppNumbEqualTo(String value) {
            addCriterion("opp_numb =", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbNotEqualTo(String value) {
            addCriterion("opp_numb <>", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbGreaterThan(String value) {
            addCriterion("opp_numb >", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbGreaterThanOrEqualTo(String value) {
            addCriterion("opp_numb >=", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbLessThan(String value) {
            addCriterion("opp_numb <", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbLessThanOrEqualTo(String value) {
            addCriterion("opp_numb <=", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbLike(String value) {
            addCriterion("opp_numb like", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbNotLike(String value) {
            addCriterion("opp_numb not like", value, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbIn(List<String> values) {
            addCriterion("opp_numb in", values, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbNotIn(List<String> values) {
            addCriterion("opp_numb not in", values, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbBetween(String value1, String value2) {
            addCriterion("opp_numb between", value1, value2, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andOppNumbNotBetween(String value1, String value2) {
            addCriterion("opp_numb not between", value1, value2, "oppNumb");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotIsNull() {
            addCriterion("not_comp_quot is null");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotIsNotNull() {
            addCriterion("not_comp_quot is not null");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotEqualTo(String value) {
            addCriterion("not_comp_quot =", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotNotEqualTo(String value) {
            addCriterion("not_comp_quot <>", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotGreaterThan(String value) {
            addCriterion("not_comp_quot >", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotGreaterThanOrEqualTo(String value) {
            addCriterion("not_comp_quot >=", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotLessThan(String value) {
            addCriterion("not_comp_quot <", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotLessThanOrEqualTo(String value) {
            addCriterion("not_comp_quot <=", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotLike(String value) {
            addCriterion("not_comp_quot like", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotNotLike(String value) {
            addCriterion("not_comp_quot not like", value, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotIn(List<String> values) {
            addCriterion("not_comp_quot in", values, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotNotIn(List<String> values) {
            addCriterion("not_comp_quot not in", values, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotBetween(String value1, String value2) {
            addCriterion("not_comp_quot between", value1, value2, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andNotCompQuotNotBetween(String value1, String value2) {
            addCriterion("not_comp_quot not between", value1, value2, "notCompQuot");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateIsNull() {
            addCriterion("last_finish_date is null");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateIsNotNull() {
            addCriterion("last_finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateEqualTo(String value) {
            addCriterion("last_finish_date =", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateNotEqualTo(String value) {
            addCriterion("last_finish_date <>", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateGreaterThan(String value) {
            addCriterion("last_finish_date >", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateGreaterThanOrEqualTo(String value) {
            addCriterion("last_finish_date >=", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateLessThan(String value) {
            addCriterion("last_finish_date <", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateLessThanOrEqualTo(String value) {
            addCriterion("last_finish_date <=", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateLike(String value) {
            addCriterion("last_finish_date like", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateNotLike(String value) {
            addCriterion("last_finish_date not like", value, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateIn(List<String> values) {
            addCriterion("last_finish_date in", values, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateNotIn(List<String> values) {
            addCriterion("last_finish_date not in", values, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateBetween(String value1, String value2) {
            addCriterion("last_finish_date between", value1, value2, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastFinishDateNotBetween(String value1, String value2) {
            addCriterion("last_finish_date not between", value1, value2, "lastFinishDate");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserIsNull() {
            addCriterion("last_trace_user is null");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserIsNotNull() {
            addCriterion("last_trace_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserEqualTo(String value) {
            addCriterion("last_trace_user =", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserNotEqualTo(String value) {
            addCriterion("last_trace_user <>", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserGreaterThan(String value) {
            addCriterion("last_trace_user >", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_trace_user >=", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserLessThan(String value) {
            addCriterion("last_trace_user <", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserLessThanOrEqualTo(String value) {
            addCriterion("last_trace_user <=", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserLike(String value) {
            addCriterion("last_trace_user like", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserNotLike(String value) {
            addCriterion("last_trace_user not like", value, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserIn(List<String> values) {
            addCriterion("last_trace_user in", values, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserNotIn(List<String> values) {
            addCriterion("last_trace_user not in", values, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserBetween(String value1, String value2) {
            addCriterion("last_trace_user between", value1, value2, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andLastTraceUserNotBetween(String value1, String value2) {
            addCriterion("last_trace_user not between", value1, value2, "lastTraceUser");
            return (Criteria) this;
        }

        public Criteria andReserveDaysIsNull() {
            addCriterion("reserve_days is null");
            return (Criteria) this;
        }

        public Criteria andReserveDaysIsNotNull() {
            addCriterion("reserve_days is not null");
            return (Criteria) this;
        }

        public Criteria andReserveDaysEqualTo(String value) {
            addCriterion("reserve_days =", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysNotEqualTo(String value) {
            addCriterion("reserve_days <>", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysGreaterThan(String value) {
            addCriterion("reserve_days >", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_days >=", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysLessThan(String value) {
            addCriterion("reserve_days <", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysLessThanOrEqualTo(String value) {
            addCriterion("reserve_days <=", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysLike(String value) {
            addCriterion("reserve_days like", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysNotLike(String value) {
            addCriterion("reserve_days not like", value, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysIn(List<String> values) {
            addCriterion("reserve_days in", values, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysNotIn(List<String> values) {
            addCriterion("reserve_days not in", values, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysBetween(String value1, String value2) {
            addCriterion("reserve_days between", value1, value2, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andReserveDaysNotBetween(String value1, String value2) {
            addCriterion("reserve_days not between", value1, value2, "reserveDays");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdIsNull() {
            addCriterion("trace_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdIsNotNull() {
            addCriterion("trace_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdEqualTo(Long value) {
            addCriterion("trace_user_id =", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdNotEqualTo(Long value) {
            addCriterion("trace_user_id <>", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdGreaterThan(Long value) {
            addCriterion("trace_user_id >", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_user_id >=", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdLessThan(Long value) {
            addCriterion("trace_user_id <", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdLessThanOrEqualTo(Long value) {
            addCriterion("trace_user_id <=", value, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdIn(List<Long> values) {
            addCriterion("trace_user_id in", values, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdNotIn(List<Long> values) {
            addCriterion("trace_user_id not in", values, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdBetween(Long value1, Long value2) {
            addCriterion("trace_user_id between", value1, value2, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andTraceUserIdNotBetween(Long value1, Long value2) {
            addCriterion("trace_user_id not between", value1, value2, "traceUserId");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNull() {
            addCriterion("en_name is null");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNotNull() {
            addCriterion("en_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnNameEqualTo(String value) {
            addCriterion("en_name =", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotEqualTo(String value) {
            addCriterion("en_name <>", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThan(String value) {
            addCriterion("en_name >", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("en_name >=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThan(String value) {
            addCriterion("en_name <", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThanOrEqualTo(String value) {
            addCriterion("en_name <=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLike(String value) {
            addCriterion("en_name like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotLike(String value) {
            addCriterion("en_name not like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameIn(List<String> values) {
            addCriterion("en_name in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotIn(List<String> values) {
            addCriterion("en_name not in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameBetween(String value1, String value2) {
            addCriterion("en_name between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotBetween(String value1, String value2) {
            addCriterion("en_name not between", value1, value2, "enName");
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