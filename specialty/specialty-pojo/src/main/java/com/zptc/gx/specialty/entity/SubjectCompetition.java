package com.zptc.gx.specialty.entity;

import java.util.Date;

public class SubjectCompetition {
    private Long id;

    private Date date;

    private String name;

    private String awardLevel;

    private String students;

    private String teachers;

    private Long specialtyId;

    private String specialtyName;

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

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel == null ? null : awardLevel.trim();
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students == null ? null : students.trim();
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers == null ? null : teachers.trim();
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName == null ? null : specialtyName.trim();
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
		return "SubjectCompetition [id=" + id + ", date=" + date + ", name=" + name + ", awardLevel=" + awardLevel
				+ ", students=" + students + ", teachers=" + teachers + ", specialtyId=" + specialtyId
				+ ", specialtyName=" + specialtyName + ", status=" + status + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", modifyTime=" + modifyTime + ", modifyUser=" + modifyUser + "]";
	}


    
}