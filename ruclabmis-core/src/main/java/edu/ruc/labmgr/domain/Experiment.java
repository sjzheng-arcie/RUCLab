package edu.ruc.labmgr.domain;

public class Experiment {
    private Integer id;

    private Short content;

    private Integer experimentInstructionsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getContent() {
        return content;
    }

    public void setContent(Short content) {
        this.content = content;
    }

    public Integer getExperimentInstructionsId() {
        return experimentInstructionsId;
    }

    public void setExperimentInstructionsId(Integer experimentInstructionsId) {
        this.experimentInstructionsId = experimentInstructionsId;
    }
}