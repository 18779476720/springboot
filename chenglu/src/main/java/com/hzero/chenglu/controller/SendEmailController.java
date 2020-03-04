package com.hzero.chenglu.controller;

import com.hzero.chenglu.unit.email.SendEmailTool;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @description: 发送邮件测试
 * @author: cheng-lu
 * @create: 2020-02-29 21:37
 */
@Api(tags = "邮件发送",hidden = true)
@RestController
@RequestMapping("/send")
public class SendEmailController {
    @Autowired
    @Qualifier("sendByEmail")
    private SendEmailTool service;

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String send(@Param("receiver") String receiver,@Param("title") String title,@Param("text") String text) {
        //这个是发送人的邮箱
        String sender = "1107956939@qq.com";
        //这个是接受人的邮箱
//        String receiver = "lu.cheng01@hand-china.com";
        //标题
//        String title = "邮箱测试";
        //邮箱内容
//        String text = "邮箱测试";
        System.out.println(sender);
        System.out.println(title);
        System.out.println(text);

        String result = service.send(sender, receiver, title, text);
        return result;
    }
}
