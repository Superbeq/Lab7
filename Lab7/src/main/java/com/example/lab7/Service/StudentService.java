package com.example.lab7.Service;


import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {



    ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents() {
        return students;
    }


    public void addStudent(Student student){

        students.add(student);

    }

    public boolean updateStudent(int id, Student student){

        for (int i = 0; i <  students.size(); i++) {
            if(students.get(i).getId() == id){
                students.set(i,student);
                return true;
            }
        }

        return false;
    }


    public boolean deleteStudent(int id){

      for (Student stud: students){

          if(stud.getId() == id){

              students.remove(stud);

              return true;

          }
      }

      return false;

    }



    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }


    public ArrayList<Student> getStudentsByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }


    public int getStudentCount() {
        return students.size();
    }




    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }


}

