package com.cl.purchase.model.base;

import java.math.BigDecimal;
import java.util.Date;

public class Supplier {
    private Integer id;

    private String name;

    private String province;

    private String city;

    private String address;

    private String postcode;

    private String contact;

    private String telephone;

    private String fax;

    private String email;

    private String website;

    private String biNo;

    private String biAddress;

    private String biPeriod;

    private String taxNo;

    private String taxPayid;

    private BigDecimal taxRate;

    private String bankName;

    private String bankNo;

    private String bankAddress;

    private Byte supplierType;

    private Byte settleType;

    private Boolean isDelete;

    private String createPerson;

    private Date createDate;

    private String updatePerson;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBiNo() {
        return biNo;
    }

    public void setBiNo(String biNo) {
        this.biNo = biNo;
    }

    public String getBiAddress() {
        return biAddress;
    }

    public void setBiAddress(String biAddress) {
        this.biAddress = biAddress;
    }

    public String getBiPeriod() {
        return biPeriod;
    }

    public void setBiPeriod(String biPeriod) {
        this.biPeriod = biPeriod;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxPayid() {
        return taxPayid;
    }

    public void setTaxPayid(String taxPayid) {
        this.taxPayid = taxPayid;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public Byte getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(Byte supplierType) {
        this.supplierType = supplierType;
    }

    public Byte getSettleType() {
        return settleType;
    }

    public void setSettleType(Byte settleType) {
        this.settleType = settleType;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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