package com.webatoz.backend.database.webatoz.category;

import com.webatoz.backend.database.webatoz.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
