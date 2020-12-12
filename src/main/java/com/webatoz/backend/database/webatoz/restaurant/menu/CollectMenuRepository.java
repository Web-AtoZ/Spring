package com.webatoz.backend.database.webatoz.restaurant.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectMenuRepository extends JpaRepository<Menu, Integer>, CollectMenuRepositoryCustom{

}
