package com.cl.purchase.model.backtrack;

import java.util.Date;

public class BacktrackForm {
    private String no;

    private Integer supplierId;

    private Integer warehouseId;

    private Byte status;

    private Byte backtrackType;

    private Byte commodityType;

    private String createPerson;

    private Date createDate;

    private String updatePerson;

    private Date updateDate;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getBacktrackType() {
        return backtrackType;
    }

    public void setBacktrackType(Byte backtrackType) {
        this.backtrackType = backtrackType;
    }

    public Byte getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Byte commodityType) {
        this.commodityType = commodityType;
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