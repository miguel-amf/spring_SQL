package com.example.sqldemo.dao;

import com.example.sqldemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();
}
