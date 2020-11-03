package com.eportfolio2077.eportfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class MailService {
        @Resource
        private JavaMailSender mailSender;
        @Value("${spring.mail.username}")
        private String mailFrom;


    public void sendVerificationMail(String mailTo, String code) throws UnsupportedEncodingException, MessagingException {
        String subject = "Verification Code";
        String name = "The ePortfolio2077 Team";

        String content = "<p>Please find the verification code below.</p>";
        content+="<h3>"+code+"</h3>";
        content+="<p>Thank you,<br>"+name+"</p>";


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper ms = new MimeMessageHelper(message);

        ms.setFrom(mailFrom,name);
        ms.setTo(mailTo);
        ms.setSubject(subject);
        ms.setText(content, true);

        mailSender.send(message);

    }

    public void sendContactMail(String mailTo, String content, String email) throws UnsupportedEncodingException, MessagingException {
        String subject = "Contact request from viewer";
        String name = "The ePortfolio2077 Team";

        String body = "<p>A viewer is interested in your portfolio(s) and use our service to inform you:<br>";
        body += content + "<br><br>";
        body += "For more information, please contact the viewer's email" + email + ".</p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper ms = new MimeMessageHelper(message);

        ms.setFrom(mailFrom,name);
        ms.setTo(mailTo);
        ms.setSubject(subject);
        ms.setText(body, true);

        mailSender.send(message);

    }
}
