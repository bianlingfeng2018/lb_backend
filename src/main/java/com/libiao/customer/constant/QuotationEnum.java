package com.libiao.customer.constant;

public enum QuotationEnum {
    STEP_QUOT_CHECK((byte)1,"报价单审核中"),
    STEP_QUOT_CHECKED((byte)2,"报价单已通过"),
    STEP_APPLY_CHECK((byte)3,"申请单待评审"),
    STEP_APPLY_PASS((byte)4,"申请单已通过"),
    STEP_WORK_CHECK((byte)5,"工作单待确认"),
    STEP_WORK_OVER((byte)6,"原始记录单已生成"),
    STEP_REPORT_CHECK((byte)7,"检测报告单审核中"),
    STEP_REPORT_PASS((byte)8,"检测报告单审核通过"),
    ;

    QuotationEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    private byte code;
    private String desc;
}
