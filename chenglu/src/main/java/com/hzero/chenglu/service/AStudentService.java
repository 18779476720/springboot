package com.hzero.chenglu.service;

import com.hzero.chenglu.entity.AStudent;
import java.util.List;

/**
 * (AStudent)表服务接口
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
public interface AStudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param lineId 主键
     * @return 实例对象
     */
    AStudent queryById(Integer lineId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AStudent> queryAllByLimit(int offset, int limit);

    List<AStudent> queryAll(AStudent aStudent);

    /**
     * 新增数据
     *
     * @param aStudent 实例对象
     * @return 实例对象
     */
    AStudent insert(AStudent aStudent);

    /**
     * 修改数据
     *
     * @param aStudent 实例对象
     * @return 实例对象
     */
    AStudent update(AStudent aStudent);

    /**
     * 通过主键删除数据
     *
     * @param lineId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer lineId);

}