package com.senani.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuilderDefault {
    @Builder.Default
    private String name = "foo";
    @Builder.Default
    private boolean original = true;
}
