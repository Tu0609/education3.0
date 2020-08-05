package com.education.user.service.impl;

import com.education.user.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author TuTu
 * @date 2020/6/24 9:14
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        //发送人
        message.setFrom("t1825095305@163.com");
        //邮箱发送至To
        message.setTo(to);
        message.setSubject(subject);
        //发送的内容
        message.setText(content);
        javaMailSender.send(message);
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content, String... cc) {

    }
}
