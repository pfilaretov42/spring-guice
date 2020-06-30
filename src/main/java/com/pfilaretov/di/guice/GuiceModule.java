package com.pfilaretov.di.guice;

import com.pfilaretov.di.entity.Person;
import com.pfilaretov.di.service.AccountService;
import com.pfilaretov.di.service.BookService;
import com.pfilaretov.di.service.BookServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pfilaretov.di.service.OptionalService;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        try {
            bind(AccountService.class).to(GuiceAccountService.class);

            // this is a collision
            bind(Person.class).toConstructor(Person.class.getConstructor());
//            bind(Person.class).toProvider(Person::new);

            // this dependency should be used with @Nullable, otherwise exception is thrown
            bind(OptionalService.class).toProvider(() -> null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Provides
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
