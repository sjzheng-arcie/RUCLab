package edu.ruc.labmgr.domain;

public class ClassStudent {
    private Integer id;

    private Integer classId;

    private Integer studentId;

    private Short usualPerformance;

    private Short finalGrade;

    private Major major;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudendId(Integer studendId) {
        this.studentId = studendId;
    }

    public Short getUsualPerformance() {
        return usualPerformance;
    }

    public void setUsualPerformance(Short usualPerformance) {
        this.usualPerformance = usualPerformance;
    }

    public Short getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Short finalGrade) {
        this.finalGrade = finalGrade;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}