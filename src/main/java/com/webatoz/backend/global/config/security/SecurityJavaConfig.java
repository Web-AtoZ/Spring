package com.webatoz.backend.global.config.security;

//import com.webatoz.backend.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .cors().disable()
        .csrf().disable()
        .formLogin().disable();

    //  iframe 허용 시
    //  .headers.frameOptions().disable();
  }
  //  @Bean
  //  public JwtUtil() {
  //    return new JwtUtil();
  //  }
}
