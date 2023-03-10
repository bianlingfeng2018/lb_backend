package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TestBusiness implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.user_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.client_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Long clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.client_name
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private String clientName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.type
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.hs_code
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private String hsCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.export_country_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Integer exportCountryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.test_standard
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private String testStandard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.create_time
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.material
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private String material;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.price
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.total_sample_cnt
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Integer totalSampleCnt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_business.test_period
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private Integer testPeriod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table test_business
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.id
     *
     * @return the value of test_business.id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.id
     *
     * @param id the value for test_business.id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.user_id
     *
     * @return the value of test_business.user_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.user_id
     *
     * @param userId the value for test_business.user_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.client_id
     *
     * @return the value of test_business.client_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.client_id
     *
     * @param clientId the value for test_business.client_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.client_name
     *
     * @return the value of test_business.client_name
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.client_name
     *
     * @param clientName the value for test_business.client_name
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.type
     *
     * @return the value of test_business.type
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.type
     *
     * @param type the value for test_business.type
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.hs_code
     *
     * @return the value of test_business.hs_code
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public String getHsCode() {
        return hsCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.hs_code
     *
     * @param hsCode the value for test_business.hs_code
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.export_country_id
     *
     * @return the value of test_business.export_country_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Integer getExportCountryId() {
        return exportCountryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.export_country_id
     *
     * @param exportCountryId the value for test_business.export_country_id
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setExportCountryId(Integer exportCountryId) {
        this.exportCountryId = exportCountryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.test_standard
     *
     * @return the value of test_business.test_standard
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public String getTestStandard() {
        return testStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.test_standard
     *
     * @param testStandard the value for test_business.test_standard
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setTestStandard(String testStandard) {
        this.testStandard = testStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.create_time
     *
     * @return the value of test_business.create_time
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.create_time
     *
     * @param createTime the value for test_business.create_time
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.material
     *
     * @return the value of test_business.material
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public String getMaterial() {
        return material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.material
     *
     * @param material the value for test_business.material
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.price
     *
     * @return the value of test_business.price
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.price
     *
     * @param price the value for test_business.price
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.total_sample_cnt
     *
     * @return the value of test_business.total_sample_cnt
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Integer getTotalSampleCnt() {
        return totalSampleCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.total_sample_cnt
     *
     * @param totalSampleCnt the value for test_business.total_sample_cnt
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setTotalSampleCnt(Integer totalSampleCnt) {
        this.totalSampleCnt = totalSampleCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_business.test_period
     *
     * @return the value of test_business.test_period
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public Integer getTestPeriod() {
        return testPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_business.test_period
     *
     * @param testPeriod the value for test_business.test_period
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    public void setTestPeriod(Integer testPeriod) {
        this.testPeriod = testPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_business
     *
     * @mbg.generated Sat Dec 24 14:02:25 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", clientId=").append(clientId);
        sb.append(", clientName=").append(clientName);
        sb.append(", type=").append(type);
        sb.append(", hsCode=").append(hsCode);
        sb.append(", exportCountryId=").append(exportCountryId);
        sb.append(", testStandard=").append(testStandard);
        sb.append(", createTime=").append(createTime);
        sb.append(", material=").append(material);
        sb.append(", price=").append(price);
        sb.append(", totalSampleCnt=").append(totalSampleCnt);
        sb.append(", testPeriod=").append(testPeriod);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}