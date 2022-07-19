package com.tmpw.expenseTracker3.service.impl;

import com.tmpw.expenseTracker3.model.Category;
import com.tmpw.expenseTracker3.repository.CategoryRepository;
import com.tmpw.expenseTracker3.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    // ====fields====
    private final CategoryRepository categoryRepository;

    // ====constructor====
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // ====public methods====

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }


    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName() != null ? category.getName() : existingCategory.getName());
        return categoryRepository.save(existingCategory);
    }
}
