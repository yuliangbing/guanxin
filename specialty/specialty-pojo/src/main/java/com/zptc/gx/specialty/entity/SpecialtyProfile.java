package com.zptc.gx.specialty.entity;

import java.util.Date;

public class SpecialtyProfile {
    private Long id;

    private Long specialtyId;

    private String specialtyName;

    private Date date;

    private String position;

    private String characteristic;

    private Long directorId;

    private String directorName;

    private Integer status;

    private Long branchIntroduction;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic == null ? null : characteristic.trim();
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName == null ? null : directorName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getBranchIntroduction() {
        return branchIntroduction;
    }

    public void setBranchIntroduction(Long branchIntroduction) {
        this.branchIntroduction = branchIntroduction;
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
		return "SpecialtyProfile [id=" + id + ", specialtyId=" + specialtyId + ", specialtyName=" + specialtyName
				+ ", date=" + date + ", position=" + position + ", characteristic=" + characteristic + ", directorId="
				+ directorId + ", directorName=" + directorName + ", status=" + status + ", branchIntroduction="
				+ branchIntroduction + ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime="
				+ modifyTime + ", modifyUser=" + modifyUser + "]";
	}
    
}