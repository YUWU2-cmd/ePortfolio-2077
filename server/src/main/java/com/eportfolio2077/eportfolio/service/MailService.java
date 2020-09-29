package com.eportfolio2077.eportfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MailService {
        @Resource
        private JavaMailSender mailSender;
        @Value("${spring.mail.username}")
        private String mailFrom;

    public void sendVerificationMail(String mailto, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(mailto);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
