package com.tmpw.expenseTracker3.service.impl;

import com.tmpw.expenseTracker3.model.Category;
import com.tmpw.expenseTracker3.repository.CategoryRepository;
import com.tmpw.expenseTracker3.service.CategoryService;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    // ====fields====
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    // ====constructor====
    public CategoryServiceImpl(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    // ====public methods====

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository
                .findAllCategoryByUserId(userService.getLoggedInUser().getId());
    }


    @Override
    public Category saveCategory(Category category) {
        category.setUser(userService.getLoggedInUser());
        return categoryRepository.save(category);
    }


    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository
                .findCategoryByUserId(userService.getLoggedInUser().getId());
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(String name, String newName) {
        Category existingCategory = categoryRepository
                .findCategoryByName(name);
        if (existingCategory.getUser().getId() == userService.getLoggedInUser().getId()
                && categoryRepository.findCategoryByName(name) != null) {
            existingCategory.setName(newName);
        }
        return categoryRepository
                .save(existingCategory);
    }
}
