package com.pfilaretov.di.spring;

import com.pfilaretov.di.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringUserService {
    private final AccountService accountService;

    @Autowired
    public SpringUserService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
