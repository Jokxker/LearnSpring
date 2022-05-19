package com.jokxker.spring.introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jokxker.spring.introduction")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
}
