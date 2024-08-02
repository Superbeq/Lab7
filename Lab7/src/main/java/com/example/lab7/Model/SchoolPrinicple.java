package com.example.lab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchoolPrinicple {




    @Positive
    @NotNull(message = "The id should not be null")
   private int id;

    @NotEmpty(message = "The name should not be empty")
   private String name;

    @NotEmpty(message = "The email should not be empty")
    @Email
   private String email;

    @NotEmpty(message = "The phone number should not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format. Must start with 05 and have 10 digits.")
    private String phoneNumber;


    @NotEmpty(message = "The school name should not be empty")
    private String school_name;




}
