package com.zhulibo.data_visualization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/auth/**") // 允许跨域访问的 API 路径
                .allowedOrigins("http://localhost:8081") // 前端地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true); // 允许凭证（如 Cookie 或 JWT）

        // 如果有其他 API 路径，也可以在这里添加 CORS 配置
    }
}
