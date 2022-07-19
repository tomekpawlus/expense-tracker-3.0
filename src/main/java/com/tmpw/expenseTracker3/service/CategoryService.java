package com.tmpw.expenseTracker3.service;

import com.tmpw.expenseTracker3.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    void deleteCategoryById(Long id);

    Category updateCategory(Long id, Category category);

}
