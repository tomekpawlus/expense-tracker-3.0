package com.tmpw.expenseTracker3.service.impl;


import com.tmpw.expenseTracker3.model.Expense;
import com.tmpw.expenseTracker3.repository.ExpenseRepository;
import com.tmpw.expenseTracker3.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return null;
    }

    @Override
    public void deleteExpenseById(Long id) {

    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return null;
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        return null;
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
