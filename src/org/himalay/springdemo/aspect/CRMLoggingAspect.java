package org.himalay.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
private Logger myLogger= Logger.getLogger(getClass().getName());
    //Some PointCut Expression
    @Pointcut("execution(* org.himalay.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}
    @Pointcut("execution(* org.himalay.springdemo.service.*.*(..))")
    private void forServicePackage(){}
    @Pointcut("execution(* org.himalay.springdemo.dao.*.*(..))")
    private void forDAOPackage(){}
    @Pointcut("forControllerPackage()||forDAOPackage()||forServicePackage()")
    private void forAppFlow(){}

    //add before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display the method we are caling
        String method=joinPoint.getSignature().toShortString();
        //System.out.println(method);
        myLogger.info("==== >> in @Before : calling Method :"+method);
        Object[] args=joinPoint.getArgs();
        for (Object tempArg:args) {
            myLogger.info(" =====>> "+tempArg);
        }
    }
    @AfterReturning(pointcut ="forAppFlow()" ,returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
//display the method we are returning from
        String method=joinPoint.getSignature().toShortString();
        //System.out.println(method);
        myLogger.info("==== >> in @After Returning : calling Method :"+method);
        //display data returned
        myLogger.info("=====>>>"+result);
    }
}