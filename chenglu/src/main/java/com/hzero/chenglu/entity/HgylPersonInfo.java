package com.hzero.chenglu.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

//@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class HgylPersonInfo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 区域
     */
    private String area;

    /**
     * 工号
     */
    private Long jobNum;

    /**
     * 名字
     */
    private String name;

    /**
     * 项目
     */
    private String project;

    /**
     * 工作形式
     */
    private String working;

    /**
     * 工作地点
     */
    private String site;

    /**
     * 入场日期
     */
    private String startDate;

    /**
     * 撤离日期
     */
    private String endDate;

    /**
     * 备注
     */
    private String remark;


    public HgylPersonInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getJobNum() {
        return jobNum;
    }

    public void setJobNum(Long jobNum) {
        this.jobNum = jobNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
