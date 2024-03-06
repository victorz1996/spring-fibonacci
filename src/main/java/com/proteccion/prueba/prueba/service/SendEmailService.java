package com.proteccion.prueba.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String sendTo, String subject, String content) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(sendTo);
        email.setSubject(subject);
        email.setText(content);

        javaMailSender.send(email);
    }
}
