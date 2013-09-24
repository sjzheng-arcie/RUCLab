package edu.ruc.labmgr.domain;

public class ExperimentDetail {
    private Integer id;

    private Integer experimentId;

    private Integer curriculumClassId;

    private Short score;

    private byte[] report;

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

    public Integer getCurriculumClassId() {
        return curriculumClassId;
    }

    public void setCurriculumClassId(Integer curriculumClassId) {
        this.curriculumClassId = curriculumClassId;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public byte[] getReport() {
        return report;
    }

    public void setReport(byte[] report) {
        this.report = report;
    }
}