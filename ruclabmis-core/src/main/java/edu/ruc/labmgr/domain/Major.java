package edu.ruc.labmgr.domain;

public class Major {
    private Integer id;

    private String name;

    private String majorcol;

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

    public String getMajorcol() {
        return majorcol;
    }

    public void setMajorcol(String majorcol) {
        this.majorcol = majorcol == null ? null : majorcol.trim();
    }
}