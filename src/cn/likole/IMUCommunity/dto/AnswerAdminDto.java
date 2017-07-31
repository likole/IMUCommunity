package cn.likole.IMUCommunity.dto;

/**
 * Created by likole on 7/31/17.
 */
public class AnswerAdminDto {
    int ansid;
    int askid;
    int uid;
    String name;
    String avatar;
    String content;
    String time;

    public int getAnsid() {
        return ansid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    public int getAskid() {
        return askid;
    }

    public void setAskid(int askid) {
        this.askid = askid;
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


}
