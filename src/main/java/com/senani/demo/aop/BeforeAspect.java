package com.senani.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect //is a combination of joint point and advice(what kinds of methods to intercept + what to do)
@Configuration
public class BeforeAspect {
    //execution(* PACKAGE.*.*(..)) <- point cut
    //execution(*(intercept all methods irrespective of their return type) PACKAGE.*(any class).*(all method calls)(..)(irrespective of their arguments))
    //JoinPoint is a specific execution instance, if you are intercepting 100 method calls -> 100 JoinPoints
    //JointPoint is a point during the execution of a program, such as the execution of a method or the handling of an exception
    //Weaver is the framework which does the entire logic of making sure the aspect is invoked at the right point
    //Weaving is the process of doing that
    //@Pointcut("execution(* PACKAGE.*.*(..))") -> to create a common pointcut and use it everywhere
    //@Pointcut("bean(*dao*)") -> look for any bean which has the name 'dao' inbetween, @Pointcut("within()") ?

    @Before("execution(* com.senani.demo.aop.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        System.out.println("interception before all methods inside 'aop' " + joinPoint);
    }

    @Before("execution(* com.senani.demo.aop.BusinessAOP.calculateSomething(..))")
    public void beforeCalculatingSomething(JoinPoint joinPoint) {
        System.out.println("interception before calculateSomething " + joinPoint);
    }

    @AfterReturning(value = "execution(* com.senani.demo.aop.BusinessAOP.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint + " after returning " + result);
    }

    @AfterThrowing(value = "execution(* com.senani.demo.aop.BusinessAOP.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Object exception) {
        System.out.println(joinPoint + " after throwing " + exception);
    }

    @After("execution(* com.senani.demo.aop.BusinessAOP.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("after " + joinPoint);
    }

    @Around("execution(* com.senani.demo.aop.BusinessAOP.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(joinPoint + " took tike aroung " + timeTaken);
    }

    @Pointcut("@annotation(com.senani.demo.aop.BeforeCalculate)")
    public void beforeCalculatePointcut() {
    }

    @Before("com.senani.demo.aop.BeforeAspect.beforeCalculatePointcut()")
    public void beforeCalculate(JoinPoint joinPoint) {
        System.out.println("Running @BeforeCalculate");
    }
}
