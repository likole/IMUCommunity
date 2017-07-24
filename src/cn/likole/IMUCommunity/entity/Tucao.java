package cn.likole.IMUCommunity.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by likole on 7/24/17.
 */
@Entity
public class Tucao {
    private int tid;
    private int uid;
    private String content;
    private Date time;
    private int likeNum;
    private int commentNum;

    @Id
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "like_num")
    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    @Basic
    @Column(name = "comment_num")
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tucao tucao = (Tucao) o;

        if (tid != tucao.tid) return false;
        if (uid != tucao.uid) return false;
        if (likeNum != tucao.likeNum) return false;
        if (commentNum != tucao.commentNum) return false;
        if (content != null ? !content.equals(tucao.content) : tucao.content != null) return false;
        if (time != null ? !time.equals(tucao.time) : tucao.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + uid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + likeNum;
        result = 31 * result + commentNum;
        return result;
    }
}
