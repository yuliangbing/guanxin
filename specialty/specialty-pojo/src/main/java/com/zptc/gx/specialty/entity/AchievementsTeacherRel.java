package com.zptc.gx.specialty.entity;

import java.util.Date;

public class AchievementsTeacherRel {
    private Long id;

    private Long teacherId;

    private String teacherCode;

    private Long issueId;

    private Long thesisId;

    private Long patentId;

    private Long textOrMonId;

    private Long otherAchId;

    private Long subComp;

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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode == null ? null : teacherCode.trim();
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getThesisId() {
        return thesisId;
    }

    public void setThesisId(Long thesisId) {
        this.thesisId = thesisId;
    }

    public Long getPatentId() {
        return patentId;
    }

    public void setPatentId(Long patentId) {
        this.patentId = patentId;
    }

    public Long getTextOrMonId() {
        return textOrMonId;
    }

    public void setTextOrMonId(Long textOrMonId) {
        this.textOrMonId = textOrMonId;
    }

    public Long getOtherAchId() {
        return otherAchId;
    }

    public void setOtherAchId(Long otherAchId) {
        this.otherAchId = otherAchId;
    }

    public Long getSubComp() {
        return subComp;
    }

    public void setSubComp(Long subComp) {
        this.subComp = subComp;
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
}