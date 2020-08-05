package com.education.user.service;

/**
 * @author TuTu
 * @date 2020/6/24 9:12
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendSimpleMail(String to, String subject, String content, String... cc);


}
