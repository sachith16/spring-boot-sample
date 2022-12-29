package com.senani.demo.model;

import lombok.Value;

@Value
//@Value is shorthand for: final @ToString @EqualsAndHashCode @AllArgsConstructor
// @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) @Getter
public class AtValue {
    private int id;
    private String value;
}
