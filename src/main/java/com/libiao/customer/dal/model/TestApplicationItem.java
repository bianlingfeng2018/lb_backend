package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestApplicationItem implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.app_sample_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private Long appSampleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.test_item_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private Long testItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.item_name
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.test_method
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private String testMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.test_case
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private String testCase;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_application_item.remark
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table test_application_item
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.id
     *
     * @return the value of test_application_item.id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.id
     *
     * @param id the value for test_application_item.id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.app_sample_id
     *
     * @return the value of test_application_item.app_sample_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public Long getAppSampleId() {
        return appSampleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.app_sample_id
     *
     * @param appSampleId the value for test_application_item.app_sample_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setAppSampleId(Long appSampleId) {
        this.appSampleId = appSampleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.test_item_id
     *
     * @return the value of test_application_item.test_item_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public Long getTestItemId() {
        return testItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.test_item_id
     *
     * @param testItemId the value for test_application_item.test_item_id
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.item_name
     *
     * @return the value of test_application_item.item_name
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.item_name
     *
     * @param itemName the value for test_application_item.item_name
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.test_method
     *
     * @return the value of test_application_item.test_method
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public String getTestMethod() {
        return testMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.test_method
     *
     * @param testMethod the value for test_application_item.test_method
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.test_case
     *
     * @return the value of test_application_item.test_case
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public String getTestCase() {
        return testCase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.test_case
     *
     * @param testCase the value for test_application_item.test_case
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_application_item.remark
     *
     * @return the value of test_application_item.remark
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_application_item.remark
     *
     * @param remark the value for test_application_item.remark
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_application_item
     *
     * @mbg.generated Sat Dec 31 17:28:35 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appSampleId=").append(appSampleId);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", testMethod=").append(testMethod);
        sb.append(", testCase=").append(testCase);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}