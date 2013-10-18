package edu.ruc.labmgr.domain;

import java.util.Date;

public class Announcement {
    private Integer id;

    private String title;

    private String content;

    private Integer publisherId;

    private Date publishTime;

    private Integer publishLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPublishLimit() {
        return publishLimit;
    }

    public void setPublishLimit(Integer publishLimit) {
        this.publishLimit = publishLimit;
    }
}