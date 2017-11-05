package com.entity;

import java.io.Serializable;
import java.util.List;

public class Email implements Serializable{
    private Integer id;

    private String content;

    private String subject;

    private String filepath;

    private String filename;

    private Integer uid;

    private User user;

    private List<Accepter> accepters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Accepter> getAccepters() {
        return accepters;
    }

    public void setAccepters(List<Accepter> accepters) {
        this.accepters = accepters;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filename='" + filename + '\'' +
                ", uid=" + uid +
                '}';
    }
}