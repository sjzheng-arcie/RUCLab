package edu.ruc.labmgr.domain;

public class Desk {
    private Integer id;

    private String name;

    private Integer laboratoryRoomId;

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

    public Integer getLaboratoryRoomId() {
        return laboratoryRoomId;
    }

    public void setLaboratoryRoomId(Integer laboratoryRoomId) {
        this.laboratoryRoomId = laboratoryRoomId;
    }
}