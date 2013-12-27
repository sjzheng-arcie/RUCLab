package edu.ruc.labmgr.domain;

import java.util.Date;

public class TermYear {
    private Integer id;

    private String name;

    private Integer startweek;

    private Integer endweek;

    private Date begindate;

    private Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStartweek() {
        return startweek;
    }

    public void setStartweek(Integer startweek) {
        this.startweek = startweek;
    }

    public Integer getEndweek() {
        return endweek;
    }

    public void setEndweek(Integer endweek) {
        this.endweek = endweek;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}