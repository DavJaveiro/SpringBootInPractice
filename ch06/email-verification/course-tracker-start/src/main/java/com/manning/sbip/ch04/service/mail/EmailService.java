package com.manning.sbip.ch04.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailTeste() {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo("teste@gmail.com");
        mensagem.


        mailSender.send(mensagem);

    }
}
