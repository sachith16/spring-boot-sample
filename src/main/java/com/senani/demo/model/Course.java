package com.senani.demo.model;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = {"id"}) @ToString(exclude = {"name"})
public class Course {
    private @Setter(AccessLevel.PRIVATE) int id;
    private String name;
}
