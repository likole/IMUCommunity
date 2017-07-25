package cn.likole.IMUCommunity.dto;

/**
 * Created by likole on 7/24/17.
 */
public class TucaoDto {
    String token;
    String selfToken;
    String content;
    String comment;
    int offset;
    int num;
    int tid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSelfToken() {
        return selfToken;
    }

    public void setSelfToken(String selfToken) {
        this.selfToken = selfToken;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
