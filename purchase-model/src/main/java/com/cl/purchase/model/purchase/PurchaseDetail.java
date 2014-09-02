package com.cl.purchase.model.purchase;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseDetail {
    private String productNo;

    private String purchaseNo;

    private Integer purchaseQuality;

    private Integer storageQuality;

    private Integer status;

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

    public Integer getPurchaseQuality() {
        return purchaseQuality;
    }

    public void setPurchaseQuality(Integer purchaseQuality) {
        this.purchaseQuality = purchaseQuality;
    }

    public Integer getStorageQuality() {
        return storageQuality;
    }

    public void setStorageQuality(Integer storageQuality) {
        this.storageQuality = storageQuality;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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