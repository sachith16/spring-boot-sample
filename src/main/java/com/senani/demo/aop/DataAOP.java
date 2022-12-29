package com.senani.demo.aop;

import org.springframework.stereotype.Repository;

@Repository
public class DataAOP {
    public String retreiveSomething() {
        return "DataAOP Return";
    }
}
