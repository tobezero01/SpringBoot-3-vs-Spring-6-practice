package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(void add* ())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }

    @After("execution(void com.luv2code.aopdemo.dao.AccountDAOImpl.addAccount())")
    public void beforeAddAccountAdvice1() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }
}











