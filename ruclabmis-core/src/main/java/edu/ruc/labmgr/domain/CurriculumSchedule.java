package edu.ruc.labmgr.domain;

public class CurriculumSchedule {
    private Integer id;

    private Integer roomId;

    private Integer classId;

    private Integer teacherid;

    private Integer curriculumId;

    private Integer termYearid;

    private Byte amPm;

    private Byte week;

    private Byte weekday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getTermYearid() {
        return termYearid;
    }

    public void setTermYearid(Integer termYearid) {
        this.termYearid = termYearid;
    }

    public Byte getAmPm() {
        return amPm;
    }

    public void setAmPm(Byte amPm) {
        this.amPm = amPm;
    }

    public Byte getWeek() {
        return week;
    }

    public void setWeek(Byte week) {
        this.week = week;
    }

    public Byte getWeekday() {
        return weekday;
    }

    public void setWeekday(Byte weekday) {
        this.weekday = weekday;
    }
}