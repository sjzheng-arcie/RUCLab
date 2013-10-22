package edu.ruc.labmgr.domain;

public class ApplicationForm {
    private Integer id;

    private String sn;

    private Integer approverId;

    private Integer operatorId;

    private Short applicationNumber;

    private Integer useDirectionId;

    private Integer stateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
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
}