package cn.likole.IMUCommunity.entity;

import javax.persistence.*;

/**
 * Created by likole on 7/27/17.
 */
@Entity
@Table(name = "Official_account", schema = "IMUCommunity", catalog = "")
public class OfficialAccount {
    private int oid;
    private String name;
    private int type;
    private String token;
    private String description;

    @Id
    @Column(name = "oid")
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficialAccount that = (OfficialAccount) o;

        if (oid != that.oid) return false;
        if (type != that.type) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
