package com.senani.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        System.out.println("Sorting using BubbleSortAlgorithm");
        return numbers;
    }
}
