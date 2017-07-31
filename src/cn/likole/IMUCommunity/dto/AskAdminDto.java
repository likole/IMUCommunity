package cn.likole.IMUCommunity.dto;

import java.util.List;

/**
 * Created by likole on 7/31/17.
 */
public class AskAdminDto {
    int aid;
    String title;
    String detail;
    int uid;
    String name;
    String avatar;
    String time;
    List<AnswerAdminDto> answerAdminDtos;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<AnswerAdminDto> getAnswerAdminDtos() {
        return answerAdminDtos;
    }

    public void setAnswerAdminDtos(List<AnswerAdminDto> answerAdminDtos) {
        this.answerAdminDtos = answerAdminDtos;
    }
}
