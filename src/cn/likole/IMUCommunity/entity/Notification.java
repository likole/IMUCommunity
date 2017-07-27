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
public class Notification {
    private int nid;
    private int oid;
    private String content;
    private byte stick;
    private byte important;
    private Timestamp time;

    @Id
    @Column(name = "nid")
    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Basic
    @Column(name = "oid")
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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
    @Column(name = "stick")
    public byte getStick() {
        return stick;
    }

    public void setStick(byte stick) {
        this.stick = stick;
    }

    @Basic
    @Column(name = "important")
    public byte getImportant() {
        return important;
    }

    public void setImportant(byte important) {
        this.important = important;
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

        Notification that = (Notification) o;

        if (nid != that.nid) return false;
        if (oid != that.oid) return false;
        if (stick != that.stick) return false;
        if (important != that.important) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nid;
        result = 31 * result + oid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) stick;
        result = 31 * result + (int) important;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
