package com.taemin.chat.user.config;

import com.taemin.chat.user.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuthService oAuthService;

    @Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(
                            "/",
                            "/login/*",
                            "/logout",
                            "/favicon.*",
                            "/error"
                    ).permitAll();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(config -> {
                    config.userInfoEndpoint(userInfoEndpointConfig -> {
                        userInfoEndpointConfig.userService(oAuthService);
                    });
                    //config.successHandler()
                    config.defaultSuccessUrl("/");
                }) // OAUTH2.0 google 로그인 허용
                .logout(Customizer.withDefaults())
                .formLogin(formLogin -> formLogin.disable()) // 기본 로그인 허용 X
                .cors(Customizer.withDefaults()) // CORS 기본 CorsConfigurationSource 사용
                .csrf(csrf -> csrf.disable()) // CSRF 방어 로직
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:51059"));//front-end cors 허용
        configuration.setAllowedMethods(Arrays.asList("GET","POST")); // get, post 만
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
