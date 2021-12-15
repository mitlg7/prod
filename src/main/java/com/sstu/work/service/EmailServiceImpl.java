package com.sstu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void send(String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("shoehubstore@yandex.ru");
        mailMessage.setText(message);
        mailMessage.setTo(email);
        emailSender.send(mailMessage);
    }
}
