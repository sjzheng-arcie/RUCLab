package edu.ruc.labmgr.domain;

public class ApplicationForm {
    private Integer id;

    private Integer equipmentId;

    private String applicant;

    private Integer userId;

    private Integer operatorId;

    private Short applicationNumber;

    private Short approvalNumber;

    private Integer useDirectionId;

    private Integer stateId;

    private Integer approverId;

    private Integer classifId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Short getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Short applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Short getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(Short approvalNumber) {
        this.approvalNumber = approvalNumber;
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

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public Integer getClassifId() {
        return classifId;
    }

    public void setClassifId(Integer classifId) {
        this.classifId = classifId;
    }
}