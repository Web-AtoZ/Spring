package com.webatoz.backend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEncryptableProperties
@EnableZuulProxy
@EnableScheduling
public class WebatozApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebatozApplication.class, args);
  }
}
