package com.hzero.chenglu.service.impl;

import com.hzero.chenglu.entity.A;
import com.hzero.chenglu.dao.ADao;
import com.hzero.chenglu.service.AService;
import com.hzero.chenglu.unit.ReturnT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (A)表服务实现类
 *
 * @author chenglu
 * @since 2020-03-08 16:46:39
 */
@Service("aService")
public class AServiceImpl implements AService {
    @Resource
    private ADao aDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public A queryById(Integer id) {
        return this.aDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<A> queryAllByLimit(int offset, int limit) {
        return this.aDao.queryAllByLimit(offset, limit);
    }
    /**
     * 查询多条数据
     *
     * @param a 实例对象
     * @return 对象列表
     */
    @Override
    public List<A> queryAll(A a) {
        return this.aDao.queryAll(a);
    }

    /**
     * 新增数据
     *
     * @param a 实例对象
     * @return 实例对象
     */
    @Override
    public A insert(A a) {
        this.aDao.insert(a);
        return a;
    }

    /**
     * 修改数据
     *
     * @param a 实例对象
     * @return 实例对象
     */
    @Override
    public A update(A a) {
        this.aDao.update(a);
        return this.queryById(a.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.aDao.deleteById(id) > 0;
    }

    /**
     * 批量插入
     */
    @Override
    public ReturnT batchInsert(List<A> a) {
        return ReturnT.buildSuccess(aDao.bacthInsert(a));
    }
}