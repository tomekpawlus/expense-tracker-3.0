package com.tmpw.expenseTracker3.repository;

import com.tmpw.expenseTracker3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByUserId(Long userid);
    List<Category> findAllCategoryByUserId(Long userId);
    Category findCategoryByName(String name);


}
