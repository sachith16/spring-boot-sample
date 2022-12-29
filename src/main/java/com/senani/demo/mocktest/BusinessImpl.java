package com.senani.demo.mocktest;

public class BusinessImpl {
    DataService dataService;

    public BusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int getLargestFromAllData() {
        return dataService.retreiveData()[1];
    }
}
