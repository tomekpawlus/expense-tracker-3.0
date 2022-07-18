package com.tmpw.expenseTracker3.repository;

import com.tmpw.expenseTracker3.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}
