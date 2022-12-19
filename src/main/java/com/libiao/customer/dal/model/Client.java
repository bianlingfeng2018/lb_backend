package com.libiao.customer.dal.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    private Long id;

    private String name;

    private String addr;

    private String abbr;

    private String nickname;

    private String source;

    private String assoCom;

    private String assoInvoice;

    private String invoiceName;

    private String invoiceTaxNum;

    private String invoiceAddr;

    private String invoiceTel;

    private String invoiceBank;

    private String invoiceAcc;

    private String invoiceIsSpec;

    private String clientClass;

    private String industClass;

    private String clientLevel;

    private String clientNum;
    private String status;
    private String oppNumb;
    private String notCompQuot;
    private String lastFinishDate;
    private String lastTraceUser;
    private String reserveDays;
    private Long traceUserId;
    private String enName;
}