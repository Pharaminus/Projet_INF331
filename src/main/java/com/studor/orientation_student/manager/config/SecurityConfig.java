// package com.studor.orientation_student.manager.config;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

// @Configuration
//    public class SecurityConfig extends WebSecurityConfiguration {

       
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .sessionManagement(management -> management
//                            .maximumSessions(2) // Limite le nombre de sessions par utilisateur
//                            .maxSessionsPreventsLogin(false) // Permet ou empêche l'utilisateur de se connecter lorsqu'il atteint la limite de sessions
//                            .expiredUrl("/session-expired-url") // URL vers laquelle rediriger lorsque la session expire
//                            .and())
//                    .authorizeRequests(requests -> {
//                     try {
//                         requests
//                            .requestMatchers("/studor/**").permitAll()
//                            .requestMatchers("/admin/**").hasRole("ADMIN")
//                            .anyRequest().authenticated()
//                            .and()
//                            .formLogin(login -> login
//                                    .loginPage("/login")
//                                    .permitAll())
//                            .logout(logout -> logout
//                                    .permitAll());
//                     } catch (Exception e) {
//                         // TODO Auto-generated catch block
//                         e.printStackTrace();
//                     }
//                 });
//        }

//        @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            // Configuration de l'authentification des utilisateurs
//            auth
//                .inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//        }
//    }
   