package com.example.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAspect {

    @Pointcut("execution(public org.springframework.http.ResponseEntity<String> com.example.aop.MessageController.getMessage())")
    public void getMessage(){}

    @Pointcut("execution(public void com.example.aop.MessageController.getThrow())")
    public void getThrow(){}

    @Before("getMessage()")
    public void beginReturnMessage() {
        System.out.println("Começou o processo de retorno da mensagem");
    }

    @After("getMessage()")
    public void completeReturnMessage() {
        System.out.println("Terminou o processo de retorno da mensagem");
    }

    @AfterReturning(value = "getMessage()", returning = "message")
    public void showBodyRequest(ResponseEntity<String> message) {
        System.out.println("Retornou o valor: " + message.getBody());
    }

    @AfterThrowing(value = "getMessage()", throwing = "e")
    public void returnThrow(Exception e) {
        System.out.println("Ocorreu uma Exception: " + e.getMessage());
    }

    @AfterThrowing("getThrow()")
    public void returnThrow() {
        System.out.println("Ocorreu uma Exception");
    }
}
