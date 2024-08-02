package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.SchoolPrinicple;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.SchoolPrincipleService;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/principle")
@RequiredArgsConstructor
public class SchoolPrincipleController {


    private final SchoolPrincipleService principleService;
    private final SchoolPrincipleService schoolPrincipleService;


    @GetMapping("/get")
    public ResponseEntity getPrinciple(){
        if (principleService.getPrinciple().isEmpty()){
            return ResponseEntity.status(404).body(new ApiResponse("The principle is not found, I think he went for breakfast"));
        }

        return ResponseEntity.status(200).body(principleService.getPrinciple());
    }


    @PostMapping("/post")
    public ResponseEntity postPrinciple(@Valid @RequestBody SchoolPrinicple prinicple, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        schoolPrincipleService.addPrinciple(prinicple);
        return ResponseEntity.status(201).body(new ApiResponse("The principle is added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePrinciple(@PathVariable int id, @Valid @RequestBody SchoolPrinicple prinicple, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(message);
        }

        boolean isUpdated = schoolPrincipleService.updatePrinciple(id,prinicple);
        if(isUpdated){
            return ResponseEntity.status(201).body(new ApiResponse("The principle has been updated successfully"));

        }

        return ResponseEntity.status(404).body(new ApiResponse("The principle is not found I think he went for lunch "));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePrinicple(@PathVariable int id){

        boolean isDeleted = principleService.deletePrinciple(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The priniciple is deleted succesfully, I hope the next principle gonna be good one"));
        }

        return ResponseEntity.status(404).body(new ApiResponse("We searched for this principle but we did not find him"));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<SchoolPrinicple> getPrincipleByName(@PathVariable String name) {
        SchoolPrinicple principle = schoolPrincipleService.getPrincipleByName(name);
        if (principle != null) {
            return ResponseEntity.ok(principle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-school-name/{schoolName}")
    public ResponseEntity<SchoolPrinicple> getPrincipleBySchoolName(@PathVariable String schoolName) {
        SchoolPrinicple principle = schoolPrincipleService.getPrincipleBySchoolName(schoolName);
        if (principle != null) {
            return ResponseEntity.ok(principle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<SchoolPrinicple> getPrincipleByEmail(@PathVariable String email) {
        SchoolPrinicple principle = schoolPrincipleService.getPrincipleByEmail(email);
        if (principle != null) {
            return ResponseEntity.ok(principle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-phone-number/{phoneNumber}")
    public ResponseEntity<SchoolPrinicple> getPrincipleByPhoneNumber(@PathVariable String phoneNumber) {
        SchoolPrinicple principle = schoolPrincipleService.getPrincipleByPhoneNumber(phoneNumber);
        if (principle != null) {
            return ResponseEntity.ok(principle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


