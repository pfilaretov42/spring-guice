package com.pfilaretov.di.spring;

import static org.junit.jupiter.api.Assertions.*;

import com.pfilaretov.di.service.AudioBookService;
import com.pfilaretov.di.service.BookService;
import com.pfilaretov.di.service.OptionalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SpringTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
    }

    @Test
    void accountServiceAutowired() {
        SpringUserService userService = context.getBean(SpringUserService.class);
        assertNotNull(userService);
        assertNotNull(userService.getAccountService());
    }

    @Test
    void bookServiceAutowired() {
        BookService bookService = context.getBean(BookService.class);
        assertNotNull(bookService);
    }

    @Test
    void bookServiceCollision() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            BookService bookService = context.getBean(BookService.class);
            assertNotNull(bookService);

            AudioBookService audioBookService = context.getBean(AudioBookService.class);
            assertNotNull(audioBookService);
        });
    }

    @Test
    void getOptionalService() {
        SpringUserService userService = context.getBean(SpringUserService.class);
        assertNotNull(userService);
        assertNull(userService.getOptionalService());
    }
}