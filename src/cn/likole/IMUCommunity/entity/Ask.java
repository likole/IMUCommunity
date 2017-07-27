package cn.likole.IMUCommunity.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by likole on 7/27/17.
 */
@Entity
public class Ask {
    private int aid;
    private String title;
    private String detail;
    private int uid;
    private Date time;

    @Id
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ask ask = (Ask) o;

        if (aid != ask.aid) return false;
        if (uid != ask.uid) return false;
        if (title != null ? !title.equals(ask.title) : ask.title != null) return false;
        if (detail != null ? !detail.equals(ask.detail) : ask.detail != null) return false;
        if (time != null ? !time.equals(ask.time) : ask.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + uid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
