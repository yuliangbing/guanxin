package com.zptc.gx.specialty.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OutstandingGraduateHistory {
    private Long id;

    private Date date;

    private String name;

    private String image;

    private String company;

    private String position;

    private String advancedDescription;

    private BigDecimal salary;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAdvancedDescription() {
        return advancedDescription;
    }

    public void setAdvancedDescription(String advancedDescription) {
        this.advancedDescription = advancedDescription == null ? null : advancedDescription.trim();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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
		return "OutstandingGraduateHistory [id=" + id + ", date=" + date + ", name=" + name + ", image=" + image
				+ ", company=" + company + ", position=" + position + ", advancedDescription=" + advancedDescription
				+ ", salary=" + salary + ", specialtyId=" + specialtyId + ", specialtyName=" + specialtyName
				+ ", status=" + status + ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime="
				+ modifyTime + ", modifyUser=" + modifyUser + "]";
	}
    
}