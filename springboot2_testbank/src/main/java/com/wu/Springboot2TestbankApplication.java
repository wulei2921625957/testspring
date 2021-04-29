package com.wu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi  //swagger3
@EnableTransactionManagement
public class Springboot2TestbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2TestbankApplication.class, args);
    }

}
