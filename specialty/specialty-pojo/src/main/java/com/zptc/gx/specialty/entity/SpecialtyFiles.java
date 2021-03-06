package com.zptc.gx.specialty.entity;

import java.util.Date;

public class SpecialtyFiles {
    private Long id;

    private Date date;

    private String code;

    private String name;

    private String cateName;

    private String reviser;

    private Long specialtyId;

    private String specialtyName;

    private String urlFileName;

    private String urlFile;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser == null ? null : reviser.trim();
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

    public String getUrlFileName() {
        return urlFileName;
    }

    public void setUrlFileName(String urlFileName) {
        this.urlFileName = urlFileName == null ? null : urlFileName.trim();
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile == null ? null : urlFile.trim();
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
		return "SpecialtyFiles [id=" + id + ", date=" + date + ", code=" + code + ", name=" + name + ", cateName="
				+ cateName + ", reviser=" + reviser + ", specialtyId=" + specialtyId + ", specialtyName="
				+ specialtyName + ", urlFileName=" + urlFileName + ", urlFile=" + urlFile + ", status=" + status
				+ ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + "]";
	}
    
}