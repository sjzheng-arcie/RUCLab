package edu.ruc.labmgr.domain;

import java.util.Date;

public class CurriculumSchedule {
    private Integer id;

    private Integer roomId;

    private Integer classId;

    private Integer teacherid;

    private Integer curriculumId;

    private Integer termYearid;

    private Byte amPm;

    private Byte weeknum;

    private Byte weekdays;

    private Date meetSTime;

    private Date meetETime;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public CurriculumClass getCurriculumClass() {
		return curriculumClass;
	}

	public void setCurriculumClass(CurriculumClass curriculumClass) {
		this.curriculumClass = curriculumClass;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public TermYear getTermYear() {
		return termYear;
	}

	public void setTermYear(TermYear termYear) {
		this.termYear = termYear;
	}

	private Room room;
	private CurriculumClass curriculumClass;

	private Teacher teacher;
	private Curriculum curriculum;
	private  TermYear termYear;

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

    public Byte getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Byte weeknum) {
        this.weeknum = weeknum;
    }

    public Byte getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Byte weekdays) {
        this.weekdays = weekdays;
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