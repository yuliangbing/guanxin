package com.zptc.gx.specialty.entity;

import java.util.Date;

public class Thesis {
    private Long id;

    private Date date;

    private String name;

    private String publishedJournal;

    private String indexLevel;

    private String awards;

    private String firstAuthor;

    private String otherAuthors;

    private Long specialtyId;

    private Integer status;

    private Date createTime;

    private String createUser;

    private Date modifyTime;

    private String modifyUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPublishedJournal() {
        return publishedJournal;
    }

    public void setPublishedJournal(String publishedJournal) {
        this.publishedJournal = publishedJournal == null ? null : publishedJournal.trim();
    }

    public String getIndexLevel() {
        return indexLevel;
    }

    public void setIndexLevel(String indexLevel) {
        this.indexLevel = indexLevel == null ? null : indexLevel.trim();
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards == null ? null : awards.trim();
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor == null ? null : firstAuthor.trim();
    }

    public String getOtherAuthors() {
        return otherAuthors;
    }

    public void setOtherAuthors(String otherAuthors) {
        this.otherAuthors = otherAuthors == null ? null : otherAuthors.trim();
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

	@Override
	public String toString() {
		return "Thesis [id=" + id + ", date=" + date + ", name=" + name + ", publishedJournal=" + publishedJournal
				+ ", indexLevel=" + indexLevel + ", awards=" + awards + ", firstAuthor=" + firstAuthor
				+ ", otherAuthors=" + otherAuthors + ", specialtyId=" + specialtyId + ", status=" + status
				+ ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + "]";
	}
    
}