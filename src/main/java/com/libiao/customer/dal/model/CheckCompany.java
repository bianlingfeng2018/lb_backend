package com.libiao.customer.dal.model;

import java.io.Serializable;

public class CheckCompany implements Serializable {
    private Long id;

    private String comName;

    private String comNameEn;

    private String comAddrCn;

    private String comAddrEn;

    private String city;

    private String cityAbbr;

    private String comPhone;

    private String comFax;

    private Byte subContract;

    private String authPerson;

    private Byte cnas;

    private Byte cma;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComNameEn() {
        return comNameEn;
    }

    public void setComNameEn(String comNameEn) {
        this.comNameEn = comNameEn;
    }

    public String getComAddrCn() {
        return comAddrCn;
    }

    public void setComAddrCn(String comAddrCn) {
        this.comAddrCn = comAddrCn;
    }

    public String getComAddrEn() {
        return comAddrEn;
    }

    public void setComAddrEn(String comAddrEn) {
        this.comAddrEn = comAddrEn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityAbbr() {
        return cityAbbr;
    }

    public void setCityAbbr(String cityAbbr) {
        this.cityAbbr = cityAbbr;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getComFax() {
        return comFax;
    }

    public void setComFax(String comFax) {
        this.comFax = comFax;
    }

    public Byte getSubContract() {
        return subContract;
    }

    public void setSubContract(Byte subContract) {
        this.subContract = subContract;
    }

    public String getAuthPerson() {
        return authPerson;
    }

    public void setAuthPerson(String authPerson) {
        this.authPerson = authPerson;
    }

    public Byte getCnas() {
        return cnas;
    }

    public void setCnas(Byte cnas) {
        this.cnas = cnas;
    }

    public Byte getCma() {
        return cma;
    }

    public void setCma(Byte cma) {
        this.cma = cma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comName=").append(comName);
        sb.append(", comNameEn=").append(comNameEn);
        sb.append(", comAddrCn=").append(comAddrCn);
        sb.append(", comAddrEn=").append(comAddrEn);
        sb.append(", city=").append(city);
        sb.append(", cityAbbr=").append(cityAbbr);
        sb.append(", comPhone=").append(comPhone);
        sb.append(", comFax=").append(comFax);
        sb.append(", subContract=").append(subContract);
        sb.append(", authPerson=").append(authPerson);
        sb.append(", cnas=").append(cnas);
        sb.append(", cma=").append(cma);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}