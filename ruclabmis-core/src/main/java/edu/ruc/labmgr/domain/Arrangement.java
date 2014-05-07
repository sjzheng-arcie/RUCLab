package edu.ruc.labmgr.domain;

import java.util.Date;

public class Arrangement {
    private Integer id;

    private Byte state;

    private Classif stateClassif;

    private Integer approvalId;

    private Integer userId;

    private String description;

    private String approvalOpinion;

    private String type;

    private Integer roomId;

    private Date scheduleDate;

    private Date meetSTime;

    private Date meetETime;

    private Room room;

    private User user;

    private User approval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Classif getStateClassif() {
        return stateClassif;
    }

    public void setStateClassif(Classif stateClassif) {
        this.stateClassif = stateClassif;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getApproval() {
        return approval;
    }

    public void setApproval(User approval) {
        this.approval = approval;
    }

    public Date getMeetSTime() {
        return meetSTime;
    }

    public void setMeetSTime(Date meetSTime) {
        this.meetSTime = meetSTime;
    }

    public Date getMeetETime() {
        return meetETime;
    }

    public void setMeetETime(Date meetETime) {
        this.meetETime = meetETime;
    }
}