package com.zptc.gx.specialty.entity;

import java.util.Date;

public class TeacherTeam {
    private Long id;

    private Long specialtyId;

    private String specialtyCode;

    private String specialtyName;

    private Date date;

    private String specialtyTeachers;

    private String partTimeTeachers;

    private String director;

    private String latest;

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

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode == null ? null : specialtyCode.trim();
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName == null ? null : specialtyName.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpecialtyTeachers() {
        return specialtyTeachers;
    }

    public void setSpecialtyTeachers(String specialtyTeachers) {
        this.specialtyTeachers = specialtyTeachers == null ? null : specialtyTeachers.trim();
    }

    public String getPartTimeTeachers() {
        return partTimeTeachers;
    }

    public void setPartTimeTeachers(String partTimeTeachers) {
        this.partTimeTeachers = partTimeTeachers == null ? null : partTimeTeachers.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest == null ? null : latest.trim();
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
		return "TeacherTeam [id=" + id + ", specialtyId=" + specialtyId + ", specialtyCode=" + specialtyCode
				+ ", specialtyName=" + specialtyName + ", date=" + date + ", specialtyTeachers=" + specialtyTeachers
				+ ", partTimeTeachers=" + partTimeTeachers + ", director=" + director + ", latest=" + latest
				+ ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + "]";
	}
    
}