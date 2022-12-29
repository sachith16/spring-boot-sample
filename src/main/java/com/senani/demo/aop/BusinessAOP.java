package com.senani.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessAOP {
    @Autowired
    DataAOP dataAOP;

    @BeforeCalculate //this is a custom annotation -> refer com.senani.demo.aop.BeforeAspect.beforeCalculatePointcut
    public String calculateSomething() {
        System.out.println("BusinessAOP Calculating Something");
        return dataAOP.retreiveSomething();
    }

}
