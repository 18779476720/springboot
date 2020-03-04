package com.hzero.chenglu.entity;

import java.io.Serializable;

/**
 * (AStudent)实体类
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
public class AStudent implements Serializable {
    private static final long serialVersionUID = 406446521217760529L;

    private Integer lineId;
    /**
     * 头id
     */
    private Integer headId;

    private String studentNumber;

    private String studentName;


    private String className;
    private String classCode;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}