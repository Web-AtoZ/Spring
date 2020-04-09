package com.webatoz.backend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEncryptableProperties
//@EnableJpaRepositories
// @EnableZuulProxy
public class WebatozApplication {
  // Test2
  public static void main(String[] args) {
    SpringApplication.run(WebatozApplication.class, args);
  }
}
