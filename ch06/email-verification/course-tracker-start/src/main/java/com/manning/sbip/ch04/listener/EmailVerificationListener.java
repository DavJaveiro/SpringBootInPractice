package com.manning.sbip.ch04.listener;

import com.manning.sbip.ch04.model.EmailVerification;
import com.manning.sbip.ch04.service.mail.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent>{

    private final JavaMailSender mailSender;
    private final EmailVerificationService emailVerificationService;

    @Autowired
    public EmailVerificationListener(JavaMailSender mailSender, EmailVerificationService emailVerificationService) {
        this.mailSender = mailSender;
        this.emailVerificationService = emailVerificationService;
    }

    public void onApplicationEvent(UserRegi)



}
