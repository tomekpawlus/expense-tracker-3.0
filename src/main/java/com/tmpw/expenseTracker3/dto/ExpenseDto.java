package com.tmpw.expenseTracker3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private String name;
    private String description;
    private Double amount;
    private Date date;
    private CategoryDto categoryDto;
}
