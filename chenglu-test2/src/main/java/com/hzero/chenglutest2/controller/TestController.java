package com.hzero.chenglutest2.controller;

import com.hzero.chenglutest2.entity.HgylPersonInfo;
import com.hzero.chenglutest2.feign.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @program: springboot
 * @description: 第二次考核controller
 * @author: cheng-lu
 * @create: 2020-02-29 13:36
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger logger ;
    @Autowired
    private TestService testService;
    private HgylPersonInfo hgylPersonInfo;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/list")
    public Object testlist(@RequestBody HgylPersonInfo hgylPersonInfo) {
        System.out.println("HgylPersonInfo:" + hgylPersonInfo.toString());
        return testService.testlist(hgylPersonInfo);
    }

    @RequestMapping("/obj")
    public Object obj(@RequestBody Object object) {
        System.out.println("object:"+object.toString());
        return testService.obj(object);
    }

    @RequestMapping(value = "/load/{id}",method = RequestMethod.GET)
    public Object testload(@PathVariable("id") int id) {
        System.out.println("id:"+id);
        Object object = testService.testLoad(id);
        System.out.println("object:"+object);

        return object;
    }

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public Object test(@PathVariable("id") int id) {
        logger.info("id"+id);
        System.out.println("id:"+id);
        Object object = testService.testLoad(id);
        System.out.println("object:"+object);
        return object;
    }
}
