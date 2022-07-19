package com.tmpw.expenseTracker3.service.impl;


import com.tmpw.expenseTracker3.model.Category;
import com.tmpw.expenseTracker3.model.Expense;
import com.tmpw.expenseTracker3.repository.CategoryRepository;
import com.tmpw.expenseTracker3.repository.ExpenseRepository;
import com.tmpw.expenseTracker3.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    // ====fields====
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    // ====constructor====
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    // ====public methods====

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findExpenseById(id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        Expense expense = expenseRepository.findExpenseById(id);
        expenseRepository.delete(expense);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        if(categoryRepository.findCategoryById(expense.getCategory().getId())==null){
            Category newCategory = new Category(expense.getCategory().getId(), expense.getCategory().getName());
            categoryRepository.save(newCategory);
        }
        return expenseRepository.save(expense);
        
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findExpenseById(id);

        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());

        return expenseRepository.save(existingExpense);
    }



    @Override
    public List<Expense> readByCategory(String category, Pageable page) {
        return null;
    }

    @Override
    public List<Expense> readByName(String keyword, Pageable page) {
        return null;
    }

    @Override
    public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
        return null;
    }
}
