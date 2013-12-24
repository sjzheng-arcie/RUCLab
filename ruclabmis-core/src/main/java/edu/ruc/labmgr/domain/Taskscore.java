package edu.ruc.labmgr.domain;

public class Taskscore {
    private Integer id;

    private Integer taskid;

    private Integer markerid;

    private Integer score;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}