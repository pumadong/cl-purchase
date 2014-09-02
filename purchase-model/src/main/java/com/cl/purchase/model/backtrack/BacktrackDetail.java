package com.cl.purchase.model.backtrack;

import java.math.BigDecimal;
import java.util.Date;

public class BacktrackDetail {
    private String productNo;

    private String backtrackNo;

    private Integer backtrackQuality;

    private Integer storageQuality;

    private Integer storageNormalQuality;

    private Integer storageBrokenQuality;

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

    public Integer getBacktrackQuality() {
        return backtrackQuality;
    }

    public void setBacktrackQuality(Integer backtrackQuality) {
        this.backtrackQuality = backtrackQuality;
    }

    public Integer getStorageQuality() {
        return storageQuality;
    }

    public void setStorageQuality(Integer storageQuality) {
        this.storageQuality = storageQuality;
    }

    public Integer getStorageNormalQuality() {
        return storageNormalQuality;
    }

    public void setStorageNormalQuality(Integer storageNormalQuality) {
        this.storageNormalQuality = storageNormalQuality;
    }

    public Integer getStorageBrokenQuality() {
        return storageBrokenQuality;
    }

    public void setStorageBrokenQuality(Integer storageBrokenQuality) {
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