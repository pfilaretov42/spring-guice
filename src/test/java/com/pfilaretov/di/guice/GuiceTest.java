package com.pfilaretov.di.guice;

import static org.junit.jupiter.api.Assertions.*;

import com.pfilaretov.di.entity.Person;
import com.pfilaretov.di.service.BookService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GuiceTest {
    private Injector injector;

    @BeforeEach
    void setUp() {
        injector = Guice.createInjector(new GuiceModule());
    }

    @Test
    void getAccountService() {
        GuiceUserService userService = injector.getInstance(GuiceUserService.class);
        assertNotNull(userService);
        assertNotNull(userService.getAccountService());
    }

    @Test
    void getBookService() {
        BookService bookService = injector.getInstance(BookService.class);
        assertNotNull(bookService);
    }

    @Test
    void getPerson() {
        Person person = injector.getInstance(Person.class);
        assertNotNull(person);
    }

    @Test
    void getOptionalService() {
        GuiceUserService userService = injector.getInstance(GuiceUserService.class);
        assertNotNull(userService);
        assertNull(userService.getOptionalService());
    }
}