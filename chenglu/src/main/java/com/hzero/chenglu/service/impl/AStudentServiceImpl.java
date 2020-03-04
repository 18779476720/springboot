package com.hzero.chenglu.service.impl;

import com.hzero.chenglu.dao.AClassDao;
import com.hzero.chenglu.entity.AClass;
import com.hzero.chenglu.entity.AStudent;
import com.hzero.chenglu.dao.AStudentDao;
import com.hzero.chenglu.service.AStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AStudent)表服务实现类
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
@Service("aStudentService")
public class AStudentServiceImpl implements AStudentService {
    @Resource
    private AStudentDao aStudentDao;
    @Resource
    private AClassDao aClassDao;

    /**
     * 通过ID查询单条数据
     *
     * @param lineId 主键
     * @return 实例对象
     */
    @Override
    public AStudent queryById(Integer lineId) {
        AStudent aStudent = this.aStudentDao.queryById(lineId);
        AClass aClass = aClassDao.queryById(aStudent.getHeadId());
        aStudent.setClassCode(aClass.getClassCode());
        aStudent.setClassName(aClass.getClassName());
        return aStudent;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AStudent> queryAllByLimit(int offset, int limit) {
        return this.aStudentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<AStudent> queryAll(AStudent aStudent) {
        List<AStudent> list = aStudentDao.queryAll(aStudent);

        if (list != null && list.size() > 0) {
            list.forEach(e -> {
                AClass aClass = new AClass();
                aClass = aClassDao.queryById(e.getHeadId());
                e.setClassName(aClass.getClassName());
                e.setClassCode(aClass.getClassCode());
            });
        }
        return list;
    }

    /**
     * 新增数据
     *
     * @param aStudent 实例对象
     * @return 实例对象
     */
    @Override
    public AStudent insert(AStudent aStudent) {
        this.aStudentDao.insert(aStudent);
        return aStudent;
    }

    /**
     * 修改数据
     *
     * @param aStudent 实例对象
     * @return 实例对象
     */
    @Override
    public AStudent update(AStudent aStudent) {
        this.aStudentDao.update(aStudent);
        return this.queryById(aStudent.getLineId());
    }

    /**
     * 通过主键删除数据
     *
     * @param lineId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer lineId) {
        return this.aStudentDao.deleteById(lineId) > 0;
    }
}