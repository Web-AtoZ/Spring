package com.webatoz.backend.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://127.0.0.1:8080", "http://127.0.0.1")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        // 자격증명과 함께 요청을 할 수 있는지 여부. 해당 서버에서 Authorization로 사용자 인증도 서비스할 것이라면 true
                        .allowCredentials(false)
                        // preflight(request.method OPTIONS) 요청의 캐시 시간
                        .maxAge(3600);
            }
        };
    }
}


