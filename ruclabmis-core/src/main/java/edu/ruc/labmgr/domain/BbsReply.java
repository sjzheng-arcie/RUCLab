package edu.ruc.labmgr.domain;

import java.util.Date;

public class BbsReply {
    private Integer id;

    private Integer topicid;

    private String title;

    private String content;

    private Integer replyuserid;

    private Date replytime;
	private String replyUsersn;
	private String replyUserName;

	public String getReplyUserRole() {
		return replyUserRole;
	}

	public void setReplyUserRole(String replyUserRole) {
		this.replyUserRole = replyUserRole;
	}

	private String replyUserRole;

	public String getReplyUsersn() {
		return replyUsersn;
	}

	public void setReplyUsersn(String replyUsersn) {
		this.replyUsersn = replyUsersn;
	}



	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
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

    public Integer getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(Integer replyuserid) {
        this.replyuserid = replyuserid;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}