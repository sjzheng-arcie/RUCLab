package edu.ruc.labmgr.domain;

public class ClassStudent {
    private Integer id;

    private Integer classId;

    private Integer studendId;

    private Short usualPerformance;

    private Short finalGrade;

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

    public Integer getStudendId() {
        return studendId;
    }

    public void setStudendId(Integer studendId) {
        this.studendId = studendId;
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