package edu.ruc.labmgr.domain;

public class ExperimentQuestion {
    private Integer id;

    private Integer experimentInstructionsId;

    private String name;

    private Short reportForm;

    private String substance;

    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperimentInstructionsId() {
        return experimentInstructionsId;
    }

    public void setExperimentInstructionsId(Integer experimentInstructionsId) {
        this.experimentInstructionsId = experimentInstructionsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getReportForm() {
        return reportForm;
    }

    public void setReportForm(Short reportForm) {
        this.reportForm = reportForm;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance == null ? null : substance.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}