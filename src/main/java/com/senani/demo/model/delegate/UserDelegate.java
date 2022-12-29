package com.senani.demo.model.delegate;

import lombok.experimental.Delegate;

public class UserDelegate implements HasContactInformation {
    @Delegate(types = {HasContactInformation.class})
    private final ContactInformationSupport contactInformation =
            new ContactInformationSupport();

    // User itself will implement all contact information by delegation
}
