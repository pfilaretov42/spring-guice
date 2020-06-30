package com.pfilaretov.di.spring;

import com.pfilaretov.di.service.AccountService;
import com.pfilaretov.di.service.OptionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringUserService {
    private final AccountService accountService;

    private OptionalService optionalService;

    @Autowired
    public SpringUserService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired(required = false)
    public void setOptionalService(OptionalService optionalService) {
        this.optionalService = optionalService;
    }

    public OptionalService getOptionalService() {
        return optionalService;
    }

    public AccountService getAccountService() {
        return accountService;
    }


}
