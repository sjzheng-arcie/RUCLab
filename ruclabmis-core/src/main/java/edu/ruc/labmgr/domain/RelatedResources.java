package edu.ruc.labmgr.domain;

import java.util.Date;

public class RelatedResources {
    private Integer id;

    private Integer curriculumId;

    private String curriculumName;

    private Integer resourceType;

    private String name;

    private String documentName;

    private String documentPath;

    private Date uploadDate;

    private Integer uploadPerson;

    private String uploadPersonName;

    private String uploadPersonSn;

    private String content;

    private Boolean downloadLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath == null ? null : documentPath.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getUploadPerson() {
        return uploadPerson;
    }

    public void setUploadPerson(Integer uploadPerson) {
        this.uploadPerson = uploadPerson;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(Boolean downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getUploadPersonName() {
        return uploadPersonName;
    }

    public void setUploadPersonName(String uploadPersonName) {
        this.uploadPersonName = uploadPersonName;
    }

    public String getUploadPersonSn() {
        return uploadPersonSn;
    }

    public void setUploadPersonSn(String uploadPersonSn) {
        this.uploadPersonSn = uploadPersonSn;
    }
}