package edu.ruc.labmgr.domain;

import java.util.Date;
import java.util.Map;

public class Experiment {
    private Integer id;

    private String name;

    private String content;

    private Integer curriculumId;

    private Boolean status;

    private Boolean needReport;

    private Date reportDeadline;

    private String templatePath;

	public Map<String, ?> getExperimentDetail() {
		return ExperimentDetail;
	}

	public void setExperimentDetail(Map<String, ?> experimentDetail) {
		ExperimentDetail = experimentDetail;
	}

	private Map<String,?> ExperimentDetail;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getNeedReport() {
        return needReport;
    }

    public void setNeedReport(Boolean needReport) {
        this.needReport = needReport;
    }

    public Date getReportDeadline() {
        return reportDeadline;
    }

    public void setReportDeadline(Date reportDeadline) {
        this.reportDeadline = reportDeadline;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath == null ? null : templatePath.trim();
    }
}