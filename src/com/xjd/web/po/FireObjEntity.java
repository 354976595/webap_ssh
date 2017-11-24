package com.xjd.web.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/11/22.
 */
@Entity
@javax.persistence.Table(name = "fire_obj", schema = "", catalog = "baoxiu")
public class FireObjEntity {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String allTroubleDetails;

    @Basic
    @javax.persistence.Column(name = "allTroubleDetails", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAllTroubleDetails() {
        return allTroubleDetails;
    }

    public void setAllTroubleDetails(String allTroubleDetails) {
        this.allTroubleDetails = allTroubleDetails;
    }

    private String busCode;

    @Basic
    @javax.persistence.Column(name = "busCode", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    private Timestamp checkDate;

    @Basic
    @javax.persistence.Column(name = "checkDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
    }

    private String checkPerson;

    @Basic
    @javax.persistence.Column(name = "checkPerson", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    private Timestamp cjDealDate;

    @Basic
    @javax.persistence.Column(name = "cjDealDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getCjDealDate() {
        return cjDealDate;
    }

    public void setCjDealDate(Timestamp cjDealDate) {
        this.cjDealDate = cjDealDate;
    }

    private String companyName;

    @Basic
    @javax.persistence.Column(name = "companyName", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private Timestamp dealDate;

    @Basic
    @javax.persistence.Column(name = "dealDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getDealDate() {
        return dealDate;
    }

    public void setDealDate(Timestamp dealDate) {
        this.dealDate = dealDate;
    }

    private String dealInfo;

    @Basic
    @javax.persistence.Column(name = "dealInfo", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDealInfo() {
        return dealInfo;
    }

    public void setDealInfo(String dealInfo) {
        this.dealInfo = dealInfo;
    }

    private String formMark;

    @Basic
    @javax.persistence.Column(name = "formMark", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFormMark() {
        return formMark;
    }

    public void setFormMark(String formMark) {
        this.formMark = formMark;
    }

    private String garage;

    @Basic
    @javax.persistence.Column(name = "garage", nullable = true, insertable = true, updatable = true, length = 255)
    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    private String imgAddress;

    @Basic
    @javax.persistence.Column(name = "imgAddress", nullable = true, insertable = true, updatable = true, length = 255)
    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    private String insulatedFast;

    @Basic
    @javax.persistence.Column(name = "insulatedFast", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInsulatedFast() {
        return insulatedFast;
    }

    public void setInsulatedFast(String insulatedFast) {
        this.insulatedFast = insulatedFast;
    }

    private String lineName;

    @Basic
    @javax.persistence.Column(name = "lineName", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    private String paizhaoCode;

    @Basic
    @javax.persistence.Column(name = "paizhaoCode", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPaizhaoCode() {
        return paizhaoCode;
    }

    public void setPaizhaoCode(String paizhaoCode) {
        this.paizhaoCode = paizhaoCode;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "remark", nullable = true, insertable = true, updatable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String sendPerson;

    @Basic
    @javax.persistence.Column(name = "sendPerson", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSendPerson() {
        return sendPerson;
    }

    public void setSendPerson(String sendPerson) {
        this.sendPerson = sendPerson;
    }

    private String state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = true, insertable = true, updatable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String subCompanyName;

    @Basic
    @javax.persistence.Column(name = "subCompanyName", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSubCompanyName() {
        return subCompanyName;
    }

    public void setSubCompanyName(String subCompanyName) {
        this.subCompanyName = subCompanyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FireObjEntity that = (FireObjEntity) o;

        if (id != that.id) return false;
        if (allTroubleDetails != null ? !allTroubleDetails.equals(that.allTroubleDetails) : that.allTroubleDetails != null)
            return false;
        if (busCode != null ? !busCode.equals(that.busCode) : that.busCode != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (checkPerson != null ? !checkPerson.equals(that.checkPerson) : that.checkPerson != null) return false;
        if (cjDealDate != null ? !cjDealDate.equals(that.cjDealDate) : that.cjDealDate != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (dealDate != null ? !dealDate.equals(that.dealDate) : that.dealDate != null) return false;
        if (dealInfo != null ? !dealInfo.equals(that.dealInfo) : that.dealInfo != null) return false;
        if (formMark != null ? !formMark.equals(that.formMark) : that.formMark != null) return false;
        if (garage != null ? !garage.equals(that.garage) : that.garage != null) return false;
        if (imgAddress != null ? !imgAddress.equals(that.imgAddress) : that.imgAddress != null) return false;
        if (insulatedFast != null ? !insulatedFast.equals(that.insulatedFast) : that.insulatedFast != null)
            return false;
        if (lineName != null ? !lineName.equals(that.lineName) : that.lineName != null) return false;
        if (paizhaoCode != null ? !paizhaoCode.equals(that.paizhaoCode) : that.paizhaoCode != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (sendPerson != null ? !sendPerson.equals(that.sendPerson) : that.sendPerson != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (subCompanyName != null ? !subCompanyName.equals(that.subCompanyName) : that.subCompanyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (allTroubleDetails != null ? allTroubleDetails.hashCode() : 0);
        result = 31 * result + (busCode != null ? busCode.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (checkPerson != null ? checkPerson.hashCode() : 0);
        result = 31 * result + (cjDealDate != null ? cjDealDate.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (dealDate != null ? dealDate.hashCode() : 0);
        result = 31 * result + (dealInfo != null ? dealInfo.hashCode() : 0);
        result = 31 * result + (formMark != null ? formMark.hashCode() : 0);
        result = 31 * result + (garage != null ? garage.hashCode() : 0);
        result = 31 * result + (imgAddress != null ? imgAddress.hashCode() : 0);
        result = 31 * result + (insulatedFast != null ? insulatedFast.hashCode() : 0);
        result = 31 * result + (lineName != null ? lineName.hashCode() : 0);
        result = 31 * result + (paizhaoCode != null ? paizhaoCode.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (sendPerson != null ? sendPerson.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (subCompanyName != null ? subCompanyName.hashCode() : 0);
        return result;
    }
}
