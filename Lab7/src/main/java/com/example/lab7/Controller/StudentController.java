package com.example.lab7.Controller;


import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping("get/all")
    public ResponseEntity getStudents(){
        if (studentService.getStudents().isEmpty()){
            return ResponseEntity.status(404).body(new ApiResponse("No any Students is found"));
        }

        return ResponseEntity.status(200).body(studentService.getStudents());
    }


    @PostMapping("post")
    public ResponseEntity postStudent(@Valid @RequestBody Student student, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("The Student is added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(message);
        }

        boolean isUpdated = studentService.updateStudent(id, student);
        if(isUpdated){
            return ResponseEntity.status(201).body(new ApiResponse("The student has been updated successfully"));

        }

        return ResponseEntity.status(404).body(new ApiResponse("Not student is found with this ID"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){

        boolean isDeleted = studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The student has been deleted successfully"));

        }

        return ResponseEntity.status(404).body(new ApiResponse("There is not student found with this id :("));
    }


    @GetMapping("/by-name/{name}")
    public ResponseEntity getStudentByName(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        if (student != null) {
            return ResponseEntity.status(200).body(student);
        }
        return ResponseEntity.status(404).body(new ApiResponse("No student found with this name"));
    }

    @GetMapping("/by-age/{age}")
    public ResponseEntity getStudentsByAge(@PathVariable int age) {
        ArrayList<Student> students = studentService.getStudentsByAge(age);
        if (students.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse("No students found with this age"));
        }
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/count")
    public ResponseEntity getStudentCount() {
        int count = studentService.getStudentCount();
        return ResponseEntity.status(200).body(new ApiResponse("Total number of students: " + count));
    }

    @GetMapping("/by-major/{major}")
    public ResponseEntity getStudentsByMajor(@PathVariable String major) {
        ArrayList<Student> students = studentService.getStudentsByMajor(major);
        if (students.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse("No students found with this major"));
        }
        return ResponseEntity.status(200).body(students);
    }


}


