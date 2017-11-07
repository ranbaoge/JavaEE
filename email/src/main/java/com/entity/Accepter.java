package com.entity;

import java.io.Serializable;

public class Accepter implements Serializable{
    private Integer id;

    private String aemail;

    private Integer eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAemail() {
        return aemail;
    }

    public void setAemail(String aemail) {
        this.aemail = aemail;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Accepter() {
    }

    public Accepter(String aemail, Integer eid) {
        this.aemail = aemail;
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Accepter{" +
                "id=" + id +
                ", aemail='" + aemail + '\'' +
                ", eid=" + eid +
                '}';
    }
}