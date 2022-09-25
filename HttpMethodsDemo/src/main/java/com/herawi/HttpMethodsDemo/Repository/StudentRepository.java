package com.herawi.HttpMethodsDemo.Repository;

import com.herawi.HttpMethodsDemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
