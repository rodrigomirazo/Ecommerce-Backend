package com.ecommerce.bicicle.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String mailMessage, String setFrom, String setTo, String subject) {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true);
            helper.setFrom(setFrom);
            helper.setTo(setTo);
            helper.setSubject(subject);
            helper.setText(mailMessage, true);
            helper.addInline("logo", new ClassPathResource("img/logo.png"));

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        javaMailSender.send(msg);
    }
}
