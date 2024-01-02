// package com.studor.orientation_student.manager.service;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @SpringBootApplication
// public class MyApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(MyApplication.class, args);
//     }

//     @Configuration
//     public class WebConfig implements WebMvcConfigurer {
//         @Override
//         public void addResourceHandlers(ResourceHandlerRegistry registry) {
//             registry.addResourceHandler("/static/**")
//                     .addResourceLocations("classpath:/static/");
//         }

//         @Override
//         public void addViewControllers(ViewControllerRegistry registry) {
//             registry.addViewController("/").setViewName("upload");
//             registry.addViewController("/result").setViewName("result");
//         }
//     }
// }