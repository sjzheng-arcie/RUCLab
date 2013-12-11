package edu.ruc.labmgr.domain;

public class Experiment {
    private Integer id;

    private String content;

    private Integer experimentInstructionsId;

    private byte[] articletemplate;
	private String experimentInstructionName;
	private String curriculumName;

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}



	public String getExperimentInstructionName() {
		return experimentInstructionName;
	}

	public void setExperimentInstructionName(String experimentInstructionName) {
		this.experimentInstructionName = experimentInstructionName;
	}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getExperimentInstructionsId() {
        return experimentInstructionsId;
    }

    public void setExperimentInstructionsId(Integer experimentInstructionsId) {
        this.experimentInstructionsId = experimentInstructionsId;
    }

    public byte[] getArticletemplate() {
        return articletemplate;
    }

    public void setArticletemplate(byte[] articletemplate) {
        this.articletemplate = articletemplate;
    }
}