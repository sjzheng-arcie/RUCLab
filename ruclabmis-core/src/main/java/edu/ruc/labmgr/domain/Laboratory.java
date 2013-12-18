package edu.ruc.labmgr.domain;

public class Laboratory {
    private Integer id;

    private String name;

    private Integer directorId;

    private String description;

	public User getDirector() {
		return director;
	}

	public void setDirector(User director) {
		this.director = director;
	}

	private User director;


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

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}