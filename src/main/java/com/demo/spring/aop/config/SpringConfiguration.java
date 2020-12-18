package com.demo.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.demo.spring.aop.aspect","com.demo.spring.aop.service"})
public class SpringConfiguration {

}
