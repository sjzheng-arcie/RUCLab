package edu.ruc.labmgr.domain;

import java.util.Date;
import java.util.List;

public class ViewStore {
    private Integer applicationId;

    private String applicationSn;

    private Integer operatorId;

    private String operatorName;

    private Integer approverId;

    private String approverName;

    private Short applicationNumber;

    private Integer useDirectionId;

    private Integer applicationStateId;

    private String applicationStateName;

    private List<Equipment> equipments;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationSn() {
        return applicationSn;
    }

    public void setApplicationSn(String applicationSn) {
        this.applicationSn = applicationSn == null ? null : applicationSn.trim();
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName == null ? null : approverName.trim();
    }

    public Short getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Short applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Integer getUseDirectionId() {
        return useDirectionId;
    }

    public void setUseDirectionId(Integer useDirectionId) {
        this.useDirectionId = useDirectionId;
    }

    public Integer getApplicationStateId() {
        return applicationStateId;
    }

    public void setApplicationStateId(Integer applicationStateId) {
        this.applicationStateId = applicationStateId;
    }

    public String getApplicationStateName() {
        return applicationStateName;
    }

    public void setApplicationStateName(String applicationStateName) {
        this.applicationStateName = applicationStateName == null ? null : applicationStateName.trim();
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}