package com.studor.orientation_student.manager.config;

import org.apache.catalina.session.StandardManager;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionIdListener;

@Configuration    
public class ApplicationConfiguration implements WebMvcConfigurer {
    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addContextCustomizers(context-> context.setManager(new StandardManager()));
        return factory;
    }

}
