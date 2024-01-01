// package com.studor.orientation_student.manager.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class securityConfig {

//     @Bean
//     public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//         return new InMemoryUserDetailsManager(
//                 User.withUsername("Balekamen").password(passwordEncoder().encode("baba")).roles("USER").build(),
//                 User.withUsername("pharaon").password(passwordEncoder().encode("baba")).roles("USER", "ADMIN").build()

//         );
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception  {
//         // httpSecurity.formLogin().loginPage("/login").permitAll();
//         httpSecurity.formLogin(login -> login.loginPage("/studor/login").permitAll());
//         // httpSecurity.formLogin(login -> login.loginPage("/test/*").permitAll());

//         // httpSecurity.formLogin();
//         // httpSecurity.authorizeHttpRequests().requestMatchers("/studor/**").hasRole("USER");
//         httpSecurity.authorizeHttpRequests().requestMatchers("/studor/**").permitAll();
//         httpSecurity.authorizeHttpRequests().requestMatchers("/test/**").permitAll();

//         httpSecurity.authorizeHttpRequests().requestMatchers("/assets/**").permitAll();

//         httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
//         httpSecurity.logout(logout -> {
//             try {
//                 logout.logoutUrl("/logout").logoutSuccessHandler(new CustomLogout()).and().csrf(csrf -> csrf.disable());
//             } catch (Exception e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         });

//         return httpSecurity.build();

//     }

//     @Bean
//     PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
