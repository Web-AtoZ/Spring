package com.webatoz.backend.database.webatoz.user;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void accessToken() {
        User user = User.builder().secret("ACCESSTOKEN").build();

        assertThat(user.getAccessToken(), is("ACCESSTOKEN"));
    }
}