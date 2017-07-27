package cn.likole.IMUCommunity.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by likole on 7/27/17.
 */
@Entity
public class Answer {
    private int ansid;
    private int aid;
    private int uid;
    private String content;
    private Timestamp time;

    @Id
    @Column(name = "ansid")
    public int getAnsid() {
        return ansid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    @Basic
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (ansid != answer.ansid) return false;
        if (aid != answer.aid) return false;
        if (uid != answer.uid) return false;
        if (content != null ? !content.equals(answer.content) : answer.content != null) return false;
        if (time != null ? !time.equals(answer.time) : answer.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ansid;
        result = 31 * result + aid;
        result = 31 * result + uid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
