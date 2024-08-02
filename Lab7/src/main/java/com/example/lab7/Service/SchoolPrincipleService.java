package com.example.lab7.Service;


import com.example.lab7.Model.SchoolPrinicple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchoolPrincipleService {




    ArrayList<SchoolPrinicple> principles = new ArrayList<>();


    public ArrayList<SchoolPrinicple> getPrinciple() {
        return principles;
    }


    public void addPrinciple(SchoolPrinicple principle){

        principles.add(principle);

    }

    public boolean updatePrinciple(int id, SchoolPrinicple principle){

        for (int i = 0; i <  principles.size(); i++) {
            if(principles.get(i).getId() == id){
                principles.set(i,principle);
                return true;
            }
            }


        return false;
    }


    public boolean deletePrinciple(int id){

        for (SchoolPrinicple princeiple: principles){

            if(princeiple.getId() == id){

                principles.remove(princeiple);

                return true;

            }
        }

        return false;

    }


    public SchoolPrinicple getPrincipleByName(String name){

        for (SchoolPrinicple principle: principles){
            if(principle.getName().equalsIgnoreCase(name)){
                return principle;
            }
        }
        return null;
    }

    public SchoolPrinicple getPrincipleBySchoolName(String school_name){

        for (SchoolPrinicple principle: principles){
            if(principle.getSchool_name().equalsIgnoreCase(school_name)){
                return principle;
            }
        }
        return null;
    }

    public SchoolPrinicple getPrincipleByEmail(String email) {
        for (SchoolPrinicple principle : principles) {
            if (principle.getEmail().equalsIgnoreCase(email)) {
                return principle;
            }
        }
        return null;
    }

    public SchoolPrinicple getPrincipleByPhoneNumber(String phone_number) {
        for (SchoolPrinicple principle : principles) {
            if (principle.getPhoneNumber().equals(phone_number)) {
                return principle;
            }
        }
        return null;
    }

}
