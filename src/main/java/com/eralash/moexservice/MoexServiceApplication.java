package com.eralash.moexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching //включаем кэш
public class MoexServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoexServiceApplication.class, args);
    }

}
