package edu.ruc.labmgr.domain;

import java.util.Date;

public class Task {
    private Integer id;

    private Boolean ifcompleted;

    private String annexname;

    private String content;

    private Integer managerid;

    private String annexpath;

    private String taskname;

    private Date finishdate;

    private Date limitdate;

    private String completion;

    private Integer completely;

    private Integer score;

    private Integer type;

    private Boolean ifscored;

    private Integer overallscore;

    private Integer completelyscore;

    private Integer timelyscore;

    private Integer qualityscore;

    private Integer spentscore;

    private Integer publisherid;

    private Integer markerid;

    private Date publishdate;

    private Boolean ifwork;

	private User manager;

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	private TaskType taskType;

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIfcompleted() {
        return ifcompleted;
    }

    public void setIfcompleted(Boolean ifcompleted) {
        this.ifcompleted = ifcompleted;
    }

    public String getAnnexname() {
        return annexname;
    }

    public void setAnnexname(String annexname) {
        this.annexname = annexname == null ? null : annexname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getAnnexpath() {
        return annexpath;
    }

    public void setAnnexpath(String annexpath) {
        this.annexpath = annexpath == null ? null : annexpath.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getLimitdate() {
        return limitdate;
    }

    public void setLimitdate(Date limitdate) {
        this.limitdate = limitdate;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion == null ? null : completion.trim();
    }

    public Integer getCompletely() {
        return completely;
    }

    public void setCompletely(Integer completely) {
        this.completely = completely;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getIfscored() {
        return ifscored;
    }

    public void setIfscored(Boolean ifscored) {
        this.ifscored = ifscored;
    }

    public Integer getOverallscore() {
        return overallscore;
    }

    public void setOverallscore(Integer overallscore) {
        this.overallscore = overallscore;
    }

    public Integer getCompletelyscore() {
        return completelyscore;
    }

    public void setCompletelyscore(Integer completelyscore) {
        this.completelyscore = completelyscore;
    }

    public Integer getTimelyscore() {
        return timelyscore;
    }

    public void setTimelyscore(Integer timelyscore) {
        this.timelyscore = timelyscore;
    }

    public Integer getQualityscore() {
        return qualityscore;
    }

    public void setQualityscore(Integer qualityscore) {
        this.qualityscore = qualityscore;
    }

    public Integer getSpentscore() {
        return spentscore;
    }

    public void setSpentscore(Integer spentscore) {
        this.spentscore = spentscore;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public Integer getMarkerid() {
        return markerid;
    }

    public void setMarkerid(Integer markerid) {
        this.markerid = markerid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Boolean getIfwork() {
        return ifwork;
    }

    public void setIfwork(Boolean ifwork) {
        this.ifwork = ifwork;
    }
}