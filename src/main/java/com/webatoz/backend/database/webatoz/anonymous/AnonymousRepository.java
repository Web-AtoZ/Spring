package com.webatoz.backend.database.webatoz.anonymous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnonymousRepository extends JpaRepository<Anonymous, String> {

    @Query("SELECT ans FROM Anonymous ans WHERE ans.name = '잘생긴도마뱀'")
    Anonymous getName();

    @Query("SELECT anonymous_id, name from Anonymous where name =?1")
    List<Anonymous> findAnonymousByName(String name);

    @Modifying
    @Query("update Anonymous a set a.name = ?1 where a.anonymous_id = ?2")
    void updateName(String name, Long anonymous_id);

    @Modifying
    @Query("delete from Anonymous a where a.anonymous_id = ?1")
    void deleteId(Long anonymous_id);

}
