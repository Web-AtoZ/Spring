package com.webatoz.backend.database.webatoz.user;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void creation() {
        User user = User.builder()
                .userId(1004)
                .id("isb9082")
                .name("임수빈")
                .email("isb9082@naver.com")
                .secret("test")
                .createdTime(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        assertThat(user.getUserId(), is(1004));
        assertThat(user.getId(), is("isb9082"));
        assertThat(user.getName(), is("임수빈"));
        assertThat(user.getEmail(), is("isb9082@naver.com"));
        assertThat(user.getSecret(), is("test"));
    }
}