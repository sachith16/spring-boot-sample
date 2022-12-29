package com.senani.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("quick")
//@Qualifier("quick")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuickSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        System.out.println("Sorting using QuickSortAlgorithm " + this);
        return numbers;
    }
}
