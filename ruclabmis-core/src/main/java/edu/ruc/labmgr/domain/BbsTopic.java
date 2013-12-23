package edu.ruc.labmgr.domain;

import java.util.Date;

public class BbsTopic {
    private Integer id;

    private Integer sessionid;

    private Integer clickcount;

    private Integer uid;

    private Integer replycount;

    private String title;

    private String contents;

    private Date creattime;

    private Integer lastreplieduser;

	private Date lastrepliedtime;

    private Boolean istop;

    private Boolean isclosed;


	private String poster;
	private String lastreplier;

	public String getLastreplier() {
		return lastreplier;
	}

	public void setLastreplier(String lastreplier) {
		this.lastreplier = lastreplier;
	}

	public String getPoster() {

		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionid() {
        return sessionid;
    }

    public void setSessionid(Integer sessionid) {
        this.sessionid = sessionid;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getLastreplieduser() {
        return lastreplieduser;
    }

    public void setLastreplieduser(Integer lastreplieduser) {
        this.lastreplieduser = lastreplieduser;
    }

    public Date getLastrepliedtime() {
        return lastrepliedtime;
    }

    public void setLastrepliedtime(Date lastrepliedtime) {
        this.lastrepliedtime = lastrepliedtime;
    }

    public Boolean getIstop() {
        return istop;
    }

    public void setIstop(Boolean istop) {
        this.istop = istop;
    }

    public Boolean getIsclosed() {
        return isclosed;
    }

    public void setIsclosed(Boolean isclosed) {
        this.isclosed = isclosed;
    }
}