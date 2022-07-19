package com.tmpw.expenseTracker3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name")
    @NotEmpty
    private String name;

}

