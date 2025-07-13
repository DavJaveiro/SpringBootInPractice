package com.manning.sbip.ch06.listener;

import com.manning.sbip.ch06.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {


    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        User user = (User) authenticationSuccessEvent.getAuthentication().getPrincipal();

        // Estamos chamando o méthod LoginSucess do serviço, passando o nome do usuário, para limpar/inativar o cache de falhas
        loginAttemptService.loginSucess(user.getUsername());



    }
}
