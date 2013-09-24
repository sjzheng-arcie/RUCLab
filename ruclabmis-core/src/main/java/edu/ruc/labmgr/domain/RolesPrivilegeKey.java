package edu.ruc.labmgr.domain;

public class RolesPrivilegeKey {
    private Short rolesId;

    private Integer privilegeId;

    public Short getRolesId() {
        return rolesId;
    }

    public void setRolesId(Short rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}