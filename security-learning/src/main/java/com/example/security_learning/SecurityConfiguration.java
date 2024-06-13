package com.example.security_learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {

   @Bean
   UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
       UserDetails user = User.withUsername("quayem")
               .password(passwordEncoder.encode("123"))
               .roles("USER")
               .build();

       UserDetails admin = User.withUsername("Ashraf")
               .password(passwordEncoder.encode("a123"))
               .roles("ADMIN")
               .build();

       return new InMemoryUserDetailsManager(user,admin);

   }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("hiAll")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("hiAdmin", "hiUser")
                .authenticated().and().formLogin().and().build();
    }
}
