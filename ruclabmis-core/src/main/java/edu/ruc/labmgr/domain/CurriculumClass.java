package edu.ruc.labmgr.domain;

public class CurriculumClass {
    private Integer id;

    private String curriculumName;

    private String teacherName;

    private String className;

    private String classSn;

    private String classYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassSn() {
        return classSn;
    }

    public void setClassSn(String classSn) {
        this.classSn = classSn == null ? null : classSn.trim();
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }
}