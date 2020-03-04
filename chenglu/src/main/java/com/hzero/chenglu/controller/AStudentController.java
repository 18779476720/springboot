package com.hzero.chenglu.controller;

import com.hzero.chenglu.entity.AStudent;
import com.hzero.chenglu.service.AStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AStudent)表控制层
 *
 * @author chenglu
 * @since 2020-03-02 19:39:47
 */
@RestController
@RequestMapping("/aStudent")
public class AStudentController {
    /**
     * 服务对象
     */
    @Resource
    private AStudentService aStudentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public AStudent selectOne(Integer id) {
        return this.aStudentService.queryById(id);
    }


}