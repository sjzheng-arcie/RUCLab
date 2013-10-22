package edu.ruc.labmgr.domain;

import java.util.Date;
import edu.ruc.labmgr.domain.User;

public class Announcement {
    private Integer id;

    private String title;

    private String content;

    private Integer publisherId;

    private Date publishTime;

    private Integer publishLimit;

	private User user;

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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}