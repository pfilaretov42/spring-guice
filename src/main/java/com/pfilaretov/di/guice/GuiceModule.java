package com.pfilaretov.di.guice;

import com.pfilaretov.di.service.AccountService;
import com.pfilaretov.di.service.BookService;
import com.pfilaretov.di.service.BookServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AccountService.class).to(GuiceAccountService.class);
    }

    @Provides
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
