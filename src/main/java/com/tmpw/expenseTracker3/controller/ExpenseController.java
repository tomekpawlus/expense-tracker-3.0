package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.model.Expense;
import com.tmpw.expenseTracker3.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseService.getAllExpenses(page);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(Long id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
        Expense newExpense = expenseService.saveExpenseDetails(expense);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/expense")
                .build();

        return ResponseEntity.created(uriComponents.toUri()).body(newExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense, @PathVariable Long id) {
        Expense updatedExpense = expenseService.updateExpenseDetails(id, expense);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/expense")
                .build();

        return ResponseEntity.created(uriComponents.toUri()).body(updatedExpense);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
    }


}
