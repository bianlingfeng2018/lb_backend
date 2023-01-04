package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class CheckCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckCompanyExample() {
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

        public Criteria andComNameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameEnIsNull() {
            addCriterion("com_name_en is null");
            return (Criteria) this;
        }

        public Criteria andComNameEnIsNotNull() {
            addCriterion("com_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEnEqualTo(String value) {
            addCriterion("com_name_en =", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotEqualTo(String value) {
            addCriterion("com_name_en <>", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnGreaterThan(String value) {
            addCriterion("com_name_en >", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("com_name_en >=", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLessThan(String value) {
            addCriterion("com_name_en <", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLessThanOrEqualTo(String value) {
            addCriterion("com_name_en <=", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLike(String value) {
            addCriterion("com_name_en like", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotLike(String value) {
            addCriterion("com_name_en not like", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnIn(List<String> values) {
            addCriterion("com_name_en in", values, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotIn(List<String> values) {
            addCriterion("com_name_en not in", values, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnBetween(String value1, String value2) {
            addCriterion("com_name_en between", value1, value2, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotBetween(String value1, String value2) {
            addCriterion("com_name_en not between", value1, value2, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIsNull() {
            addCriterion("com_addr_cn is null");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIsNotNull() {
            addCriterion("com_addr_cn is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrCnEqualTo(String value) {
            addCriterion("com_addr_cn =", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotEqualTo(String value) {
            addCriterion("com_addr_cn <>", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnGreaterThan(String value) {
            addCriterion("com_addr_cn >", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnGreaterThanOrEqualTo(String value) {
            addCriterion("com_addr_cn >=", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLessThan(String value) {
            addCriterion("com_addr_cn <", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLessThanOrEqualTo(String value) {
            addCriterion("com_addr_cn <=", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLike(String value) {
            addCriterion("com_addr_cn like", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotLike(String value) {
            addCriterion("com_addr_cn not like", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIn(List<String> values) {
            addCriterion("com_addr_cn in", values, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotIn(List<String> values) {
            addCriterion("com_addr_cn not in", values, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnBetween(String value1, String value2) {
            addCriterion("com_addr_cn between", value1, value2, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotBetween(String value1, String value2) {
            addCriterion("com_addr_cn not between", value1, value2, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIsNull() {
            addCriterion("com_addr_en is null");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIsNotNull() {
            addCriterion("com_addr_en is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrEnEqualTo(String value) {
            addCriterion("com_addr_en =", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotEqualTo(String value) {
            addCriterion("com_addr_en <>", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnGreaterThan(String value) {
            addCriterion("com_addr_en >", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnGreaterThanOrEqualTo(String value) {
            addCriterion("com_addr_en >=", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLessThan(String value) {
            addCriterion("com_addr_en <", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLessThanOrEqualTo(String value) {
            addCriterion("com_addr_en <=", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLike(String value) {
            addCriterion("com_addr_en like", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotLike(String value) {
            addCriterion("com_addr_en not like", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIn(List<String> values) {
            addCriterion("com_addr_en in", values, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotIn(List<String> values) {
            addCriterion("com_addr_en not in", values, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnBetween(String value1, String value2) {
            addCriterion("com_addr_en between", value1, value2, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotBetween(String value1, String value2) {
            addCriterion("com_addr_en not between", value1, value2, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityAbbrIsNull() {
            addCriterion("city_abbr is null");
            return (Criteria) this;
        }

        public Criteria andCityAbbrIsNotNull() {
            addCriterion("city_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andCityAbbrEqualTo(String value) {
            addCriterion("city_abbr =", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrNotEqualTo(String value) {
            addCriterion("city_abbr <>", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrGreaterThan(String value) {
            addCriterion("city_abbr >", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("city_abbr >=", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrLessThan(String value) {
            addCriterion("city_abbr <", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrLessThanOrEqualTo(String value) {
            addCriterion("city_abbr <=", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrLike(String value) {
            addCriterion("city_abbr like", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrNotLike(String value) {
            addCriterion("city_abbr not like", value, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrIn(List<String> values) {
            addCriterion("city_abbr in", values, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrNotIn(List<String> values) {
            addCriterion("city_abbr not in", values, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrBetween(String value1, String value2) {
            addCriterion("city_abbr between", value1, value2, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andCityAbbrNotBetween(String value1, String value2) {
            addCriterion("city_abbr not between", value1, value2, "cityAbbr");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNull() {
            addCriterion("com_phone is null");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNotNull() {
            addCriterion("com_phone is not null");
            return (Criteria) this;
        }

        public Criteria andComPhoneEqualTo(String value) {
            addCriterion("com_phone =", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotEqualTo(String value) {
            addCriterion("com_phone <>", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThan(String value) {
            addCriterion("com_phone >", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("com_phone >=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThan(String value) {
            addCriterion("com_phone <", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThanOrEqualTo(String value) {
            addCriterion("com_phone <=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLike(String value) {
            addCriterion("com_phone like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotLike(String value) {
            addCriterion("com_phone not like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneIn(List<String> values) {
            addCriterion("com_phone in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotIn(List<String> values) {
            addCriterion("com_phone not in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneBetween(String value1, String value2) {
            addCriterion("com_phone between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotBetween(String value1, String value2) {
            addCriterion("com_phone not between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComFaxIsNull() {
            addCriterion("com_fax is null");
            return (Criteria) this;
        }

        public Criteria andComFaxIsNotNull() {
            addCriterion("com_fax is not null");
            return (Criteria) this;
        }

        public Criteria andComFaxEqualTo(String value) {
            addCriterion("com_fax =", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotEqualTo(String value) {
            addCriterion("com_fax <>", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxGreaterThan(String value) {
            addCriterion("com_fax >", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxGreaterThanOrEqualTo(String value) {
            addCriterion("com_fax >=", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLessThan(String value) {
            addCriterion("com_fax <", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLessThanOrEqualTo(String value) {
            addCriterion("com_fax <=", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxLike(String value) {
            addCriterion("com_fax like", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotLike(String value) {
            addCriterion("com_fax not like", value, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxIn(List<String> values) {
            addCriterion("com_fax in", values, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotIn(List<String> values) {
            addCriterion("com_fax not in", values, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxBetween(String value1, String value2) {
            addCriterion("com_fax between", value1, value2, "comFax");
            return (Criteria) this;
        }

        public Criteria andComFaxNotBetween(String value1, String value2) {
            addCriterion("com_fax not between", value1, value2, "comFax");
            return (Criteria) this;
        }

        public Criteria andSubContractIsNull() {
            addCriterion("sub_contract is null");
            return (Criteria) this;
        }

        public Criteria andSubContractIsNotNull() {
            addCriterion("sub_contract is not null");
            return (Criteria) this;
        }

        public Criteria andSubContractEqualTo(Byte value) {
            addCriterion("sub_contract =", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotEqualTo(Byte value) {
            addCriterion("sub_contract <>", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractGreaterThan(Byte value) {
            addCriterion("sub_contract >", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractGreaterThanOrEqualTo(Byte value) {
            addCriterion("sub_contract >=", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractLessThan(Byte value) {
            addCriterion("sub_contract <", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractLessThanOrEqualTo(Byte value) {
            addCriterion("sub_contract <=", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractIn(List<Byte> values) {
            addCriterion("sub_contract in", values, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotIn(List<Byte> values) {
            addCriterion("sub_contract not in", values, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractBetween(Byte value1, Byte value2) {
            addCriterion("sub_contract between", value1, value2, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotBetween(Byte value1, Byte value2) {
            addCriterion("sub_contract not between", value1, value2, "subContract");
            return (Criteria) this;
        }

        public Criteria andAuthPersonIsNull() {
            addCriterion("auth_person is null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonIsNotNull() {
            addCriterion("auth_person is not null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonEqualTo(String value) {
            addCriterion("auth_person =", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNotEqualTo(String value) {
            addCriterion("auth_person <>", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonGreaterThan(String value) {
            addCriterion("auth_person >", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonGreaterThanOrEqualTo(String value) {
            addCriterion("auth_person >=", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonLessThan(String value) {
            addCriterion("auth_person <", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonLessThanOrEqualTo(String value) {
            addCriterion("auth_person <=", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonLike(String value) {
            addCriterion("auth_person like", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNotLike(String value) {
            addCriterion("auth_person not like", value, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonIn(List<String> values) {
            addCriterion("auth_person in", values, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNotIn(List<String> values) {
            addCriterion("auth_person not in", values, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonBetween(String value1, String value2) {
            addCriterion("auth_person between", value1, value2, "authPerson");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNotBetween(String value1, String value2) {
            addCriterion("auth_person not between", value1, value2, "authPerson");
            return (Criteria) this;
        }

        public Criteria andCnasIsNull() {
            addCriterion("cnas is null");
            return (Criteria) this;
        }

        public Criteria andCnasIsNotNull() {
            addCriterion("cnas is not null");
            return (Criteria) this;
        }

        public Criteria andCnasEqualTo(Byte value) {
            addCriterion("cnas =", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasNotEqualTo(Byte value) {
            addCriterion("cnas <>", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasGreaterThan(Byte value) {
            addCriterion("cnas >", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasGreaterThanOrEqualTo(Byte value) {
            addCriterion("cnas >=", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasLessThan(Byte value) {
            addCriterion("cnas <", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasLessThanOrEqualTo(Byte value) {
            addCriterion("cnas <=", value, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasIn(List<Byte> values) {
            addCriterion("cnas in", values, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasNotIn(List<Byte> values) {
            addCriterion("cnas not in", values, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasBetween(Byte value1, Byte value2) {
            addCriterion("cnas between", value1, value2, "cnas");
            return (Criteria) this;
        }

        public Criteria andCnasNotBetween(Byte value1, Byte value2) {
            addCriterion("cnas not between", value1, value2, "cnas");
            return (Criteria) this;
        }

        public Criteria andCmaIsNull() {
            addCriterion("cma is null");
            return (Criteria) this;
        }

        public Criteria andCmaIsNotNull() {
            addCriterion("cma is not null");
            return (Criteria) this;
        }

        public Criteria andCmaEqualTo(Byte value) {
            addCriterion("cma =", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaNotEqualTo(Byte value) {
            addCriterion("cma <>", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaGreaterThan(Byte value) {
            addCriterion("cma >", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaGreaterThanOrEqualTo(Byte value) {
            addCriterion("cma >=", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaLessThan(Byte value) {
            addCriterion("cma <", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaLessThanOrEqualTo(Byte value) {
            addCriterion("cma <=", value, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaIn(List<Byte> values) {
            addCriterion("cma in", values, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaNotIn(List<Byte> values) {
            addCriterion("cma not in", values, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaBetween(Byte value1, Byte value2) {
            addCriterion("cma between", value1, value2, "cma");
            return (Criteria) this;
        }

        public Criteria andCmaNotBetween(Byte value1, Byte value2) {
            addCriterion("cma not between", value1, value2, "cma");
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