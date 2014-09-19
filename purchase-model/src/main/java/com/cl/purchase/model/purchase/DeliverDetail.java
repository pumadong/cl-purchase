package com.cl.purchase.model.purchase;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverDetail {
    private String productNo;

    private String deliverNo;

    private Short deliverQuality;

    private Short storageQuality;

    private Short storageNormalQuality;

    private Short storageBrokenQuality;

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

    public String getDeliverNo() {
        return deliverNo;
    }

    public void setDeliverNo(String deliverNo) {
        this.deliverNo = deliverNo;
    }

    public Short getDeliverQuality() {
        return deliverQuality;
    }

    public void setDeliverQuality(Short deliverQuality) {
        this.deliverQuality = deliverQuality;
    }

    public Short getStorageQuality() {
        return storageQuality;
    }

    public void setStorageQuality(Short storageQuality) {
        this.storageQuality = storageQuality;
    }

    public Short getStorageNormalQuality() {
        return storageNormalQuality;
    }

    public void setStorageNormalQuality(Short storageNormalQuality) {
        this.storageNormalQuality = storageNormalQuality;
    }

    public Short getStorageBrokenQuality() {
        return storageBrokenQuality;
    }

    public void setStorageBrokenQuality(Short storageBrokenQuality) {
        this.storageBrokenQuality = storageBrokenQuality;
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