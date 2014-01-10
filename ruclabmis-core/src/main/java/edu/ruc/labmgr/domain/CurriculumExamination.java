package edu.ruc.labmgr.domain;

public class CurriculumExamination {
    private Integer id;

    private String name;

    private String documentName;

    private String documentPath;

    private String comment;

    private String curriculumName;



	private String teachername;



	private String teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName == null ? null : documentName.trim();
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath == null ? null : documentPath.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
}