package com.example.lab7.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {


    @Positive
    @NotNull(message = "The id should not be null")
   private int id;


    @NotEmpty(message = "The name should not empty")
   private String name;



    @Positive
    @NotNull(message = "The age should not be null")
   private int age;

    @NotEmpty(message = "The email should not empty")
    @Email
 private String email;

    @NotEmpty(message = "The major should not empty")
   private String major;




}
