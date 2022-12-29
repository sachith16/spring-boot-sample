package com.senani.demo.model;

import lombok.*;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true) @Getter @Setter
@EqualsAndHashCode
public class LoginResult {
    private final @NonNull String loginTs;
    private final @NonNull String authToken;
    private final @NonNull boolean tokenValidity;
    private String tokenRefreshUrl;

}
