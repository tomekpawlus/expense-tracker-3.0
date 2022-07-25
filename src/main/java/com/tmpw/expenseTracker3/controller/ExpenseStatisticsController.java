package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.service.ExpenseStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("/statistics")
public class ExpenseStatisticsController {

    private final ExpenseStatisticsService expenseStatisticService;

    public ExpenseStatisticsController(ExpenseStatisticsService expenseStatisticService) {
        this.expenseStatisticService = expenseStatisticService;
    }

    @GetMapping("/sum")
    public double getSumOfAllExpenses(){
        return 0;
    }

    public double getSumOfAllExpensesInLastMonth(){
        return 0;
    }

    public double getSumOfExpensesInPeriod(Date fromDate, Date toDate){
        return 0;
    }

    public double getSumOfExpensesByCategory(){
        return 0;
    }

    public double getPercentageExpensesByCategory(){
        return 0;
    }


}
