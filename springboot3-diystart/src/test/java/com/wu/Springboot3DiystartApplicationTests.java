package com.wu;

import com.wu.starter.helloworld.services.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot3DiystartApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void contextLoads() {
        System.out.println(helloService.say());
    }

}
