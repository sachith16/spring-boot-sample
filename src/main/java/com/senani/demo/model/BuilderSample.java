package com.senani.demo.model;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class BuilderSample {
    private String loginId;
    private String authToken;
    private boolean tokenValidity;
}
