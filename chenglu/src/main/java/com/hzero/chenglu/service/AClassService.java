package com.hzero.chenglu.service;

import com.hzero.chenglu.entity.AClass;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * (AClass)表服务接口
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
public interface AClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param headId 主键
     * @return 实例对象
     */
    AClass queryById(Integer headId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AClass> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param aClass 实例对象
     * @return 实例对象
     */
    AClass insert(AClass aClass);

    /**
     * 修改数据
     *
     * @param aClass 实例对象
     * @return 实例对象
     */
    AClass update(AClass aClass);

    /**
     * 通过主键删除数据
     *
     * @param headId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer headId);

    AClass threadInsert(AClass aClass) throws InterruptedException, ExecutionException;

}