package com.cl.purchase.model.purchase;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseDetail {
    private String productNo;

    private String purchaseNo;

    private Short purchaseQuality;

    private Short storageQuality;

    private Byte status;

    private BigDecimal purchasePrice;

    private String createPerson;

    private Date createDate;

    private String updatePerson;

    private Date updateDate;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public Short getPurchaseQuality() {
        return purchaseQuality;
    }

    public void setPurchaseQuality(Short purchaseQuality) {
        this.purchaseQuality = purchaseQuality;
    }

    public Short getStorageQuality() {
        return storageQuality;
    }

    public void setStorageQuality(Short storageQuality) {
        this.storageQuality = storageQuality;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}