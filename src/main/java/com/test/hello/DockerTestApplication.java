package com.test.hello;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEncryptableProperties
@EnableZuulProxy
public class DockerTestApplication {
  // Test2
  public static void main(String[] args) {
    SpringApplication.run(DockerTestApplication.class, args);
  }
}
