package com.test.hello.database.webatoz.anonymous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnonymousRepository extends JpaRepository<Anonymous, String> {

    @Query("SELECT ans FROM Anonymous ans WHERE ans.name = '잘생긴도마뱀'")
    Anonymous getName();
}
