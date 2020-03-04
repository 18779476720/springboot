package com.hzero.chenglu.unit.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author :cheng-lu
 * @date :2020/2/29 21:36
 * @description: 邮件发送
 * @modified By：
 * @version: 1.0
 */
@Service("sendByEmail")
public class SendEmailTool {
    @Autowired
    private JavaMailSender jms;

    public String send(String sender, String receiver, String title, String text) {
        //建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送者
        System.out.println("发送者 ------------------");
        mailMessage.setFrom(sender);
        System.out.println("接收者 ------------------");
        //接收者
        mailMessage.setTo(receiver);

        //发送的标题
        mailMessage.setSubject(title);
        //发送的内容
        mailMessage.setText(text);
        jms.send(mailMessage);
        return "1";
    }
}
