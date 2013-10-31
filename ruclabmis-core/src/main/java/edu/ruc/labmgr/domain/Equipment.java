package edu.ruc.labmgr.domain;

import java.util.Date;

public class Equipment {

    private Integer id;

    private String categoryId;

    private String sn;

    private String name;

    private String modelNumber;

    private String specifications;

    private Float unitPrice;

    private String vender;

    private String factoryNumber;

    private Date manufactureDate;

    private Date acquisitionDate;

    private Date scrapDate;

    private String country;

    private Integer fundingSubjectId;

    private String fundingSubject;

    private Integer useDirectionId;

    private String useDirection;

    private Integer stateId;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber == null ? null : modelNumber.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender == null ? null : vender.trim();
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber == null ? null : factoryNumber.trim();
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Date getScrapDate() {
        return scrapDate;
    }

    public void setScrapDate(Date scrapDate) {
        this.scrapDate = scrapDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getFundingSubjectId() {
        return fundingSubjectId;
    }

    public void setFundingSubjectId(Integer fundingSubjectId) {
        this.fundingSubjectId = fundingSubjectId;
    }

    public Integer getUseDirectionId() {
        return useDirectionId;
    }

    public void setUseDirectionId(Integer useDirectionId) {
        this.useDirectionId = useDirectionId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getFundingSubject() {
        return fundingSubject;
    }

    public void setFundingSubject(String fundingSubject) {
        this.fundingSubject = fundingSubject;
    }

    public String getUseDirection() {
        return useDirection;
    }

    public void setUseDirection(String useDirection) {
        this.useDirection = useDirection;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}