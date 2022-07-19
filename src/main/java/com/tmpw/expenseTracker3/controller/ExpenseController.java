package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.model.Expense;
import com.tmpw.expenseTracker3.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public Page<Expense> getAllExpenses(Pageable page){
        return expenseService.getAllExpenses(page);
    }

}
