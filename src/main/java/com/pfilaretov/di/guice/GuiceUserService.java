package com.pfilaretov.di.guice;


import com.pfilaretov.di.service.AccountService;
import com.google.inject.Inject;

public class GuiceUserService {
    @Inject
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }
}
