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

    private Boolean ifscored;

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	private User manager;

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

    public Boolean getIfscored() {
        return ifscored;
    }

    public void setIfscored(Boolean ifscored) {
        this.ifscored = ifscored;
    }
}