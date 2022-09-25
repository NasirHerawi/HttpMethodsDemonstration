package com.herawi.HttpMethodsDemo.Controller;

import com.herawi.HttpMethodsDemo.Model.Student;
import com.herawi.HttpMethodsDemo.Repository.StudentRepository;
import com.herawi.HttpMethodsDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController


@RequestMapping ("/api/students")
public class StudentController {
    @Autowired
    public StudentService studentService;
    @Autowired
    public StudentRepository studentRepository;

    /* Write a http Method that calls another function from the Service layer
    this function "this case POST" saves an object in DB in */


    @PostMapping("/new")

    public void savestudentobject(@RequestBody Student student) {
        studentService.saveStudent(student);
    }


    @GetMapping("/listAllStudents")
    public List<Student> getallstudent() {
        return studentService.listAllStudents();
    }


    //http DELETE Method TO delete a Particular student with ID.

    @DeleteMapping ("/{studentID}")
    public void deleteobject(@PathVariable long studentID){
        studentService.deletestudentbyID(studentID);
    }

    // HTTP get method to directly save data in DB.
    @GetMapping("/listnewStudent")
    public List<Student> listnewstudents() {
        List<Student> newstudent = new ArrayList<>();
        newstudent.add(new Student(66, "Abdul Zahir", "Sales"));
        newstudent.add(new Student(646, "KABIR", "Operations"));
        return newstudent;


    }

    @PostMapping("/directindb")
    public Student savestudentindb(){
      Student shgard =   new Student(66, "Abdul Zahir", "Sales");
       Student nasir= new Student(646, "KABIR", "Operations");
        return studentRepository.save(shgard);

    }

    // PUT Method to update data in DB,We call our method from Businee layer
    //for this purpose.

    @PutMapping( value = "/update")
    public Student updateStudentone (@RequestBody Student student){
        studentRepository.save(student);
        return studentService.updatestudent(student);

    }

    // A http method in this case "Get method"to retrieve a student by a particular ID.

    @GetMapping("/{studentID}")
    public ResponseEntity<Student> get(@PathVariable Long studentID) {
        Student student;
        try {
            student = studentService.Findbyid(studentID);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }


        }
    }


