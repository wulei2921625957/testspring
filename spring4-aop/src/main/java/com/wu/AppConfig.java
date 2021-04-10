package com.wu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 29216
 */
@Configuration
@ComponentScan(basePackages = {"com.wu"})
//启用AspectJ支持
@EnableAspectJAutoProxy
public class AppConfig {


}
