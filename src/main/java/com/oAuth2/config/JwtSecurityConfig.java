package com.oAuth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableConfigurationProperties(ServerSecurityProperties.class)
@EnableWebSecurity
public class JwtSecurityConfig {

    private ServerSecurityProperties properties;


    @Autowired
    public JwtSecurityConfig(ServerSecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationConverter customJwtAuthConverter = new CustomAuthenticationConverter(
                properties.getIdentityClaimLabel());

        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers(properties.getAuthenticatedPathMatchers().stream().toArray(String[]::new)).authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(customJwtAuthConverter))
                );

        return http.build();
    }

}
