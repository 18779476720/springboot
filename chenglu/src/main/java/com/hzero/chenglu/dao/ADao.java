package com.hzero.chenglu.dao;

import com.hzero.chenglu.entity.A;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (A)表数据库访问层
 *
 * @author chenglu
 * @since 2020-03-08 16:46:39
 */
 @Mapper
public interface ADao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    A queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<A> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param a 实例对象
     * @return 对象列表
     */
    List<A> queryAll(A a);

    /**
     * 新增数据
     *
     * @param a 实例对象
     * @return 影响行数
     */
    int insert(A a);

    /**
     * 修改数据
     *
     * @param a 实例对象
     * @return 影响行数
     */
    int update(A a);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 批量插入
     * @param
     * @return
     */
    int bacthInsert(List<A> a);

}