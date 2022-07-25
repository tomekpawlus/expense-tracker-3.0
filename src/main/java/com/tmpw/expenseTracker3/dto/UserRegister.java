package com.tmpw.expenseTracker3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {

    @NotBlank(message = "Name should not be empty")
    private String username;

    @NotNull(message = "Password should not be empty")
    @Size(min = 5, message = "Password should have at least 5 characters")
    private String password;

}
