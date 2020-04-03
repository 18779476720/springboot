package com.hzero.chenglu.service;

import com.hzero.chenglu.entity.A;
import com.hzero.chenglu.unit.ReturnT;

import java.util.List;

/**
 * (A)表服务接口
 *
 * @author chenglu
 * @since 2020-03-08 16:46:39
 */
public interface AService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    A queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<A> queryAllByLimit(int offset, int limit);
    /**
     * 查询多条数据
     *
     * @param a 实例对象
     * @return 对象列表
     */
    List<A> queryAll(A a);

    /**
     * 新增数据
     *
     * @param a 实例对象
     * @return 实例对象
     */
    A insert(A a);

    /**
     * 修改数据
     *
     * @param a 实例对象
     * @return 实例对象
     */
    A update(A a);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量插入
     */
    public ReturnT batchInsert(List<A> a);

}