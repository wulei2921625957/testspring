package com.wu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(ConfiguretionProperties.class)
public class Springboot3DiystartApplication {
    Log log = LogFactory.getLog(Springboot3DiystartApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Springboot3DiystartApplication.class, args);
    }

    @Autowired
    private DBHelper dbHelper;

    @Autowired
    private Environment environment;


    @RequestMapping("/con")
    private String getCon() {
        log.info("debug");
        log.info("系统的环境变量：" + environment);
        log.info(environment.getProperty("wu.starter.name"));
        log.info(environment.getProperty("user.home"));
        log.info(environment.getProperty("JAVA_HOME"));
        return dbHelper.getConnection().toString();
    }
}
