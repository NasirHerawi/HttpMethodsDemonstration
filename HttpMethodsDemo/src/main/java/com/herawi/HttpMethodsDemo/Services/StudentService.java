package com.herawi.HttpMethodsDemo.Services;

import com.herawi.HttpMethodsDemo.Model.Student;
import com.herawi.HttpMethodsDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class StudentService {
    @Autowired

    public StudentRepository studentRepository;
    public Student student;

    // Write a Service "Function" To save a student in DB.

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    //A function to List all employees
    public List<Student> listAllStudents(){
        return  studentRepository.findAll();

    }
    // A business logic "FUNCTION" tO Find a particular student with ID.
    public Student Findbyid(Long studentID){
        return studentRepository.findById(studentID).get();
    }

    //a service to Delete a Student BY a specific ID.
    public void deletestudentbyID(long studentID) {
        studentRepository.deleteById(studentID);

    }

    // A function to update Student details.
    public   Student updatestudent(Student student) {
     return    studentRepository.save(student);
    }
}
