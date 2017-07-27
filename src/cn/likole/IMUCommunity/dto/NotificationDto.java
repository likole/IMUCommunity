package cn.likole.IMUCommunity.dto;

/**
 * Created by likole on 7/27/17.
 */
public class NotificationDto {
    int nid;
    int oid;
    String name;
    String content;
    String time;
    byte important;
    byte stick;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public byte getImportant() {
        return important;
    }

    public void setImportant(byte important) {
        this.important = important;
    }

    public byte getStick() {
        return stick;
    }

    public void setStick(byte stick) {
        this.stick = stick;
    }
}
