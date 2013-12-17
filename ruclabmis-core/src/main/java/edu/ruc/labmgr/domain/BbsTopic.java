package edu.ruc.labmgr.domain;

import java.util.Date;

public class BbsTopic {
    private Integer id;

    private Integer sessionid;

    private Integer clickcount;

    private Integer uid;

    private Integer replycount;

    private Integer title;

    private Integer contents;

    private Date creattime;

    private Integer lastreplieduser;

    private Date lastrepliedtime;

    private Boolean istop;

    private Boolean isclosed;

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

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getContents() {
        return contents;
    }

    public void setContents(Integer contents) {
        this.contents = contents;
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