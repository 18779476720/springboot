package com.hzero.chenglu.controller;


import com.hzero.chenglu.entity.AClass;
import com.hzero.chenglu.service.AClassService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * (AClass)表控制层
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
@Api(description = "班级测试",tags = "班级接口")
@RestController
@RequestMapping("/aClass")
public class AClassController {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 服务对象
     */
    @Resource
    private AClassService aClassService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public AClass selectOne(Integer id) {
        return this.aClassService.queryById(id);
    }
    public Object insert(@RequestBody AClass aClass) {


        System.out.println("正常插入##################---"+df.format(new Date())+"--###############");
        Object object = aClassService.insert(aClass);
        System.out.println("正常插入##################---"+df.format(new Date())+"--###############");
        return object;
    }

    /**
     * description: thirdinsert 大数据使用线程插入
     * date: 2020/3/3 20:02
     *
     * @param aClass
     * @return com.hzero.chenglu.entity.AClass
     */
    @PostMapping("/thirdInsert")
    public Object thirdinsert(@RequestBody AClass aClass) throws ExecutionException, InterruptedException {
        System.out.println("批量插入##################---"+df.format(new Date())+"--###############");
        Object object =  aClassService.threadInsert(aClass);
        System.out.println("批量插入##################---"+df.format(new Date())+"--###############");
        return object;
    }
}