package com.senani.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${external.service.url}")
    //@Value("${externalServiceUrl}")
    private String url;

    public String getUrl() {
        return url;
    }
}
