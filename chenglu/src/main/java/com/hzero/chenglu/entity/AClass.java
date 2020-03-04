package com.hzero.chenglu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (AClass)实体类
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
public class AClass implements Serializable {
    private static final long serialVersionUID = -91487854517273793L;
    /**
    * PK
    */
    private Integer headId;
    /**
    * 班级编码
    */
    private String classCode;
    /**
    * 班级名称
    */
    private String className;
    /**
     * 关联行表
     */
    private List<AStudent> students;

    public List<AStudent> getStudents() {
        return students;
    }

    public void setStudents(List<AStudent> students) {
        this.students = students;
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}