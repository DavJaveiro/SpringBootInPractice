package com.manning.sbip.ch04.exception;

import lombok.Getter;

@Getter // gerando automaticamente o method Getter do lombok
public class UrlNotAccessibleException extends RuntimeException {

    /*Esse campo armazena a URL que causou o erro, ou seja, a que estava inacessível*/
    private String url;


    /*Esse construtor chama o segundo construtor (que aceita também uma causa), mas passando null como causa. Ou seja, esse é um atalho para instanciar a exceção sem stacktrace adicional.*/
    public UrlNotAccessibleException(String url) {
        this(url, null);
    }

    /*super() chama o construtor da RuntimeException, passando a mensagem personalizada ( "URL xyz is not accessible*/
    public UrlNotAccessibleException(String url, Throwable cause) {
        super("URL " + url + " is not accessible", cause);
        this.url = url;
    }
}
