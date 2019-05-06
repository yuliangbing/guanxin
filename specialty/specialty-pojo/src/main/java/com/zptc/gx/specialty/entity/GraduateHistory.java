package com.zptc.gx.specialty.entity;

import java.math.BigDecimal;
import java.util.Date;

public class GraduateHistory {
    private Long id;

    private Date date;

    private Integer graduateNum;

    private Integer employedNum;

    private Integer entrepreneursNum;

    private BigDecimal employmentRate;

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

    public Integer getGraduateNum() {
        return graduateNum;
    }

    public void setGraduateNum(Integer graduateNum) {
        this.graduateNum = graduateNum;
    }

    public Integer getEmployedNum() {
        return employedNum;
    }

    public void setEmployedNum(Integer employedNum) {
        this.employedNum = employedNum;
    }

    public Integer getEntrepreneursNum() {
        return entrepreneursNum;
    }

    public void setEntrepreneursNum(Integer entrepreneursNum) {
        this.entrepreneursNum = entrepreneursNum;
    }

    public BigDecimal getEmploymentRate() {
        return employmentRate;
    }

    public void setEmploymentRate(BigDecimal employmentRate) {
        this.employmentRate = employmentRate;
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
		return "GraduateHistory [id=" + id + ", date=" + date + ", graduateNum=" + graduateNum + ", employedNum="
				+ employedNum + ", entrepreneursNum=" + entrepreneursNum + ", employmentRate=" + employmentRate
				+ ", specialtyId=" + specialtyId + ", specialtyName=" + specialtyName + ", status=" + status
				+ ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + "]";
	}
    
}