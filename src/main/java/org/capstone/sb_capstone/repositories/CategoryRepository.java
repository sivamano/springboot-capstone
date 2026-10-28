package org.capstone.sb_capstone.repositories;

import org.capstone.sb_capstone.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);

    Category save(Category category);

}
