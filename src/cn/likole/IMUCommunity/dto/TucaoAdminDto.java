package cn.likole.IMUCommunity.dto;

import cn.likole.IMUCommunity.entity.Comments;

import java.util.List;

/**
 * Created by likole on 7/30/17.
 */
public class TucaoAdminDto {
    int tid;
    int uid;
    String name;
    String content;
    String time;
    int like_num;
    int comment_num;
    List<LikesAdminDto> like;
    List<Comments> comments;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public List<LikesAdminDto> getLike() {
        return like;
    }

    public void setLike(List<LikesAdminDto> like) {
        this.like = like;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
