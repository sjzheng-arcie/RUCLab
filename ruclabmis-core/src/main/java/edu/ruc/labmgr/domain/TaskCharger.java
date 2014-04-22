package edu.ruc.labmgr.domain;

public class TaskCharger {
    private Integer id;

    private Integer taskid;

    private Integer chargerid;

    private Integer score;

	public User getCharger() {
		return charger;
	}

	public void setCharger(User charger) {
		this.charger = charger;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	private User charger;

	private Task task;


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

    public Integer getChargerid() {
        return chargerid;
    }

    public void setChargerid(Integer chargerid) {
        this.chargerid = chargerid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}