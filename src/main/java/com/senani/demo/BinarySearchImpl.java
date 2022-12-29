package com.senani.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class BinarySearchImpl {

    private SortAlgorithm sortAlgorithm;

    @Autowired
    public BinarySearchImpl(@Qualifier("quick") SortAlgorithm sortAlgorithm) {
        System.out.println("BinarySearchImpl Constructor");
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int[] numbers, int number) {
        sortAlgorithm.sort(numbers);
        return 2;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BinarySearchImpl PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BinarySearchImpl PreDestroy");
    }
}
