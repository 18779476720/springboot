package com.hzero.chenglu.service.impl;

import com.hzero.chenglu.dao.AStudentDao;
import com.hzero.chenglu.entity.AClass;
import com.hzero.chenglu.dao.AClassDao;
import com.hzero.chenglu.entity.AStudent;
import com.hzero.chenglu.service.AClassService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * (AClass)表服务实现类
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
@Service("aClassService")
public class AClassServiceImpl implements AClassService {
    @Resource
    private AClassDao aClassDao;
    @Resource
    private AStudentDao aStudentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param headId 主键
     * @return 实例对象
     */
    @Override
    public AClass queryById(Integer headId) {
        AClass aClass = this.aClassDao.queryById(headId);
        AStudent aStudent = new AStudent();
        aStudent.setHeadId(aClass.getHeadId());
        aClass.setStudents(aStudentDao.queryAll(aStudent));
        return aClass;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AClass> queryAllByLimit(int offset, int limit) {
        return this.aClassDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param aClass 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public AClass insert(AClass aClass) {

        try {
            this.aClassDao.insert(aClass);
        } catch (DataAccessException e) {
            System.out.println("数据库异常;" + e.getMessage());
            System.out.println("数据库详细报错信息：" + e.getCause());
            System.out.println("数据库详细报错信息：" + e.getRootCause());
        }

        int headId = aClass.getHeadId();
        List<AStudent> list = aClass.getStudents();
        //list != null  需要写在 前面否则 list=null 时 list.size() 会报空指针异常
        if (list != null && list.size() > 0) {
            list.forEach(e -> {
                e.setHeadId(headId);
            });
            try {
                aStudentDao.bacthInsert(list);
            } catch (DataAccessException e) {
                System.out.println("数据库异常;" + e.getMessage());
            }

        }

        return aClass;
    }

    /**
     * 修改数据
     *
     * @param aClass 实例对象
     * @return 实例对象
     */
    @Override
    public AClass update(AClass aClass) {
        this.aClassDao.update(aClass);
        return this.queryById(aClass.getHeadId());
    }

    /**
     * 通过主键删除数据
     *
     * @param headId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer headId) {
        return this.aClassDao.deleteById(headId) > 0;
    }

    /**
     * 多线程新增数据
     *
     * @param aClass 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public AClass threadInsert(AClass aClass) throws InterruptedException, ExecutionException {
        List<AStudent> list = aClass.getStudents();
        //每500条数据开启一个线程
        int threadSize = 1000;
        int remainder = list.size() % threadSize;
        //线程数
        int threadNum = 0;
        this.aClassDao.insert(aClass);
        int headId = aClass.getHeadId();

        //多线程
        if (remainder == 0) {
            threadNum = list.size() / threadSize;
        } else {
            threadNum = list.size() / threadSize + 1;
        }
        //创建一个线程池
        ExecutorService eService = Executors.newFixedThreadPool(threadNum);

        List<Callable<AStudent>> cList = new ArrayList<>();
        Callable<AStudent> task = null;
        List<AStudent> sList = null;
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                sList = list.subList(i * threadSize, list.size());
            } else {
                sList = list.subList(i * threadSize, (i + 1) * threadSize);
            }
            List<AStudent> nowList = sList;
            task = new Callable<AStudent>() {
                @Override
                public AStudent call() throws Exception {
                    //线程需要做的事
                    nowList.forEach(e -> {
                        e.setHeadId(headId);
                    });
                    aStudentDao.bacthInsert(nowList);
                    return null;
                }
            };
            cList.add(task);
        }
        List<Future<AStudent>> results = eService.invokeAll(cList);
        eService.shutdown();
        return aClass;
    }
}