package com.pfilaretov.di.spring;

import com.pfilaretov.di.service.AudioBookService;
import com.pfilaretov.di.service.AudioBookServiceImpl;
import com.pfilaretov.di.service.BookService;
import com.pfilaretov.di.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.pfilaretov")
public class SpringMainConfig {
    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }

    // create a collision with the bookService bean above
    @Bean("bookService")
    public AudioBookService audioBookService() {
        return new AudioBookServiceImpl();
    }
}
