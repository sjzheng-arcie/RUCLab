package edu.ruc.labmgr.domain;

public class Taskscore {
    private Integer id;

    private Integer taskid;

    private Integer markerid;

    private Integer overallscore;

    private Integer completelyscore;

    private Integer timelyscore;

    private Integer qualityscore;

    private Integer spentscore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getMarkerid() {
        return markerid;
    }

    public void setMarkerid(Integer markerid) {
        this.markerid = markerid;
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
}