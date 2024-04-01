package com.kitchen.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "kitchen/orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "kitchen/orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "kitchen/orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "kitchen/orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "kitchen/orders/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        // in general, not required when using HTTP Basic authentication

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
