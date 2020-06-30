package com.pfilaretov.di.guice;


import com.pfilaretov.di.service.AccountService;
import com.google.inject.Inject;
import com.pfilaretov.di.service.OptionalService;

import javax.annotation.Nullable;

public class GuiceUserService {
    @Inject
    private AccountService accountService;

    @Inject
    @Nullable
    private OptionalService optionalService;

    public AccountService getAccountService() {
        return accountService;
    }

    public OptionalService getOptionalService() {
        return optionalService;
    }
}
