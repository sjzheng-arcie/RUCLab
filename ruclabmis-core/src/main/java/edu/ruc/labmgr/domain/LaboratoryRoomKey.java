package edu.ruc.labmgr.domain;

public class LaboratoryRoomKey {
    private Integer laboratoryRoomId;

    private Integer laboratoryId;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	private Room room;

    public Integer getLaboratoryRoomId() {
        return laboratoryRoomId;
    }

    public void setLaboratoryRoomId(Integer laboratoryRoomId) {
        this.laboratoryRoomId = laboratoryRoomId;
    }

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }
}