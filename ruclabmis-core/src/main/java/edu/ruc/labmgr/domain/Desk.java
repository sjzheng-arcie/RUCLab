package edu.ruc.labmgr.domain;

public class Desk {
    private Integer id;

    private String name;

    private Integer laboratoryRoomId;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}