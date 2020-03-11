package com.test.hello.config.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptConfigTest {

    @Test
    public void test() {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("test");

        String url = "jdbc:postgresql://35.190.236.211:5432/webatoz";
        String username = "admin";
        String password = "cafe24@001";

        System.out.println("기존 URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
        System.out.println("기존 username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username));
        System.out.println("기존 password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
    }
}