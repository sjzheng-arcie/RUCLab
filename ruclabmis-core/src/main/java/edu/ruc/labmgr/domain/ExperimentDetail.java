package edu.ruc.labmgr.domain;

public class ExperimentDetail {
    private Integer id;

    private Integer experimentId;

    private Integer classStudentId;

    private String reportPath;

    private Short score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getClassStudentId() {
        return classStudentId;
    }

    public void setClassStudentId(Integer classStudentId) {
        this.classStudentId = classStudentId;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath == null ? null : reportPath.trim();
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
}