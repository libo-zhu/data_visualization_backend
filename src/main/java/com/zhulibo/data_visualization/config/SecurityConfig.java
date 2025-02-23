package com.zhulibo.data_visualization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 启用 CORS 配置
                .cors(Customizer.withDefaults())
                // 禁用 CSRF
                .csrf(csrf -> csrf.disable())
                // 配置所有请求不需要认证
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // 所有请求都不需要认证
                )
                // 禁用默认的表单登录
                .formLogin(form -> form.disable());

        return http.build();
    }
}
