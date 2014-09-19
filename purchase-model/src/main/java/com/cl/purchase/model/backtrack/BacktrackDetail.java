package com.cl.purchase.model.backtrack;

import java.math.BigDecimal;
import java.util.Date;

public class BacktrackDetail {
    private String productNo;

    private String backtrackNo;

    private Short backtrackQuality;

    private Short storageQuality;

    private Short storageNormalQuality;

    private Short storageBrokenQuality;

    private BigDecimal backtrackPrice;

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

    public String getBacktrackNo() {
        return backtrackNo;
    }

    public void setBacktrackNo(String backtrackNo) {
        this.backtrackNo = backtrackNo;
    }

    public Short getBacktrackQuality() {
        return backtrackQuality;
    }

    public void setBacktrackQuality(Short backtrackQuality) {
        this.backtrackQuality = backtrackQuality;
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

    public BigDecimal getBacktrackPrice() {
        return backtrackPrice;
    }

    public void setBacktrackPrice(BigDecimal backtrackPrice) {
        this.backtrackPrice = backtrackPrice;
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