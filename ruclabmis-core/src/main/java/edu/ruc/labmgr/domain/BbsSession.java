package edu.ruc.labmgr.domain;

public class BbsSession {
    private Integer id;

    private String description;

    private Integer topiccount;

    private Integer replycount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getTopiccount() {
        return topiccount;
    }

    public void setTopiccount(Integer topiccount) {
        this.topiccount = topiccount;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }
}