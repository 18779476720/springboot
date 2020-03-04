package com.hzero.chenglu.dao;

import com.hzero.chenglu.entity.AClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * (AClass)表数据库访问层
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
 @Mapper
public interface AClassDao {

    /**
     * 通过ID查询单条数据
     *
     * @param headId 主键
     * @return 实例对象
     */
    AClass queryById(Integer headId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AClass> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param aClass 实例对象
     * @return 对象列表
     */
    List<AClass> queryAll(AClass aClass);

    /**
     * 新增数据
     *
     * @param aClass 实例对象
     * @return 影响行数
     */
    int insert(AClass aClass) throws DataAccessException;

    /**
     * 修改数据
     *
     * @param aClass 实例对象
     * @return 影响行数
     */
    int update(AClass aClass);

    /**
     * 通过主键删除数据
     *
     * @param headId 主键
     * @return 影响行数
     */
    int deleteById(Integer headId);

}