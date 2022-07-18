package com.tmpw.expenseTracker3.service;

import com.tmpw.expenseTracker3.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> getAllCategories(Pageable page);
    Category saveCategory(Category category);
    void deleteCategoryById(Long id);
    Category updateCategory(Long id, Category category);

}
