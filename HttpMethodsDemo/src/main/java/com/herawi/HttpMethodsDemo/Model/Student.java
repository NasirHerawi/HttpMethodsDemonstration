package com.herawi.HttpMethodsDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "students")


@NoArgsConstructor


public class Student {
    @Id
    private long studentID;
    @ Column (name = "Student_Name",unique = true )
    private String studentName;
    @Column (name = "Student_Major")
    private String studentMajor;

    public Student(long studentID, String studentName, String studentMajor) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentMajor = studentMajor;
    }
}
