package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.model.Category;
import com.tmpw.expenseTracker3.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    // ====fields====
    private final CategoryService categoryService;

    // ====constructor====
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    // ====public methods====

    @GetMapping
    public List<Category> getAllCategories (){
        return categoryService.getAllCategories();
    }


    @PostMapping
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category){
        Category newCategory = categoryService.saveCategory(category);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/category")
                .build();
        return ResponseEntity.created(uriComponents.toUri()).body(newCategory);
    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategory(@RequestParam Long id){
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody String newName, @PathVariable String name){
        Category updatedCategory = categoryService.updateCategory(name, newName);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/category")
                .build();
        return ResponseEntity.created(uriComponents.toUri()).body(updatedCategory);
    }
}
