package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findByCategoryNameEquals(String categoryName);
}
