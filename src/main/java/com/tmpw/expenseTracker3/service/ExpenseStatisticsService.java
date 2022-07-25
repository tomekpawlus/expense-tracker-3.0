package com.tmpw.expenseTracker3.service;

import java.util.Date;

public interface ExpenseStatisticsService {

    double getSumOfAllExpenses();

    double getSumOfAllExpensesInLastMonth();

    double getSumOfExpensesInPeriod(Date fromDate, Date toDate);

    double getSumOfExpensesByCategory(String categoryName);

    double getPercentageExpensesByCategory();

}
