package com.manning.sbip.ch06.handler;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/*Define uma estratégia de redirecionamento padrão.
	* Essa estratégia é usada para enviar o usuário para URLs específicas com base na fallha de login.*/
	private DefaultRedirectStrategy defaultRedirectStrategy = new DefaultRedirectStrategy();
	
    public void onAuthenticationFailure(
			HttpServletRequest request,
			HttpServletResponse response,
			AuthenticationException exception)
			throws IOException, ServletException {

		/*Se o erro for causado por uma conta desabilitada (ex: usuário inativo),
		* redireciona para o endpoint específico "/login-disabled".*/
    	if(exception instanceof DisabledException) {
    		defaultRedirectStrategy.sendRedirect(request, response, "/login-disabled");
    		return;
    	}

		/*Se a causa da exceção for uma conta bloqueada,
		* redireciona para o endpoint "login-locked"*/
		if(exception.getCause() instanceof LockedException) {
			defaultRedirectStrategy.sendRedirect(request, response, "/login-locked");
			return;
		}
    	defaultRedirectStrategy.sendRedirect(request, response, "/login-error");
    }
}
