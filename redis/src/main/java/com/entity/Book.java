package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Book {
    private Integer bid;

    private String bname;

    private String bauthor;

    private String bpublisher;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bpublishdate;

    private Integer bcid;
    
    private Category category;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor == null ? null : bauthor.trim();
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher == null ? null : bpublisher.trim();
    }

    public Date getBpublishdate() {
        return bpublishdate;
    }

    public void setBpublishdate(Date bpublishdate) {
        this.bpublishdate = bpublishdate;
    }

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", bpublisher=" + bpublisher
				+ ", bpublishdate=" + bpublishdate + ", bcid=" + bcid + ", category=" + category + "]";
	}
    
}