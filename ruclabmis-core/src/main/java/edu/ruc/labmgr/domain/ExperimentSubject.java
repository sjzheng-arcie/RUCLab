package edu.ruc.labmgr.domain;

public class ExperimentSubject {
    private Integer id;

    private String name;

    private String substance;

    private String remark ;

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

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance == null ? null : substance.trim();
    }

    public String getRemark() {
        return remark ;
    }

    public void setRemark(String remark ) {
        this.remark  = remark  == null ? null : remark .trim();
    }
}