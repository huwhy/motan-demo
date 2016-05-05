package com.nachepin.web.config;

import com.nachepin.web.controller.IndexController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {IndexController.class})
public class ApplicationConfig {

}
