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

    CN_PAPER((byte)1,"中文纸质档"),
    CN_E_FILE((byte)2,"中文电子档"),
    EN_PAPER((byte)3,"英文纸质档"),
    EN_E_FILE((byte)4,"英文电子档"),

    PRICE_CHECK((byte)1,"价格待审核"),
    PRICE_REFUSE((byte)2,"价格审核不通过"),
    NOT_PAID((byte)3,"未支付"),
    CREDIT((byte)4,"已挂账"),
    PART_PAID((byte)5,"已付部分"),
    TOTAL_PAID((byte)6,"已全付"),

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
