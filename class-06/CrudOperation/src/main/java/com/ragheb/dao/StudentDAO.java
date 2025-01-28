package com.ragheb.dao;

import com.ragheb.entity.Student;

public interface StudentDAO {
    void saveStudent(Student student);
    Student loadStudent(int id);
    Student updateStudent(int id, int marks);
    void deleteStudent(int id);
}
