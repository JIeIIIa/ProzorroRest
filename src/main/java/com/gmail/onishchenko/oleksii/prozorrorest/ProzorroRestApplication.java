package com.gmail.onishchenko.oleksii.prozorrorest;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProzorroRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProzorroRestApplication.class, args);
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}

