package edu.ruc.labmgr.domain;

public class CurriculumClass {
    private Integer id;

    private Integer curriculumId;

    private Integer studentId;

    private Short usualPerformance;

    private Short finalGrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
}