package edu.ruc.labmgr.domain;

import java.util.List;

public class ExperimentInstructions {
    private Integer id;

    private String name;

    private String purpose;

    private String explanation;

    private String documentPath;

    private Integer curriculumId;

    List<ExperimentSubject> subjects;

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
        this.name = name == null ? null : name.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath == null ? null : documentPath.trim();
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public List<ExperimentSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<ExperimentSubject> subjects) {
        this.subjects = subjects;
    }
}