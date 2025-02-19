package com.ragheb.dao;

import com.ragheb.entity.Student;
import com.ragheb.entity.StudentCompositeKey;

public interface StudentDAO {

    void saveStudent(Student student);

    Student fetchStudent(StudentCompositeKey compositeKey);
}
