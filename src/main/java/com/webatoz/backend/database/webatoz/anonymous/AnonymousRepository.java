package com.webatoz.backend.database.webatoz.anonymous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnonymousRepository extends JpaRepository<Anonymous, Long> {

    @Query("SELECT anonymousId, name from Anonymous where name = :#{#name}")
    List<Anonymous> findAnonymousByName(String name);

    @Modifying
    @Query("update Anonymous a set a.name = :#{#name} where a.anonymousId = :#{#anonymousId}")
    void updateName(String name, Long anonymousId);

    @Modifying
    @Query("delete from Anonymous a where a.anonymousId = :#{#anonymousId}")
    void deleteId(Long anonymousId);

}
