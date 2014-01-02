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

	public ClassStudent getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(ClassStudent classStudent) {
		this.classStudent = classStudent;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	private Teacher teacher;
	private ClassStudent classStudent;

	private Curriculum curriculum;

	private TermYear termYear;

	private Room room;

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