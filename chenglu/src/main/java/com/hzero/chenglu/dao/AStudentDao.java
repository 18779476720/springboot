package com.hzero.chenglu.dao;

import com.hzero.chenglu.entity.AStudent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (AStudent)表数据库访问层
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
@Mapper
public interface AStudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param lineId 主键
     * @return 实例对象
     */
    AStudent queryById(Integer lineId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AStudent> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param aStudent 实例对象
     * @return 对象列表
     */
    List<AStudent> queryAll(AStudent aStudent);

    /**
     * 新增数据
     *
     * @param aStudent 实例对象
     * @return 影响行数
     */
    int insert(AStudent aStudent);

    /**
     * 批量新增数据
     *
     * @param list 实例对象
     * @return 影响行数
     */
    void bacthInsert(List<AStudent> list);

    /**
     * 修改数据
     *
     * @param aStudent 实例对象
     * @return 影响行数
     */
    int update(AStudent aStudent);

    /**
     * 通过主键删除数据
     *
     * @param lineId 主键
     * @return 影响行数
     */
    int deleteById(Integer lineId);

}