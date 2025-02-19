package com.ragheb.client;

import com.ragheb.dao.StudentDAO;
import com.ragheb.dao.impl.StudentDAOImpl;
import com.ragheb.entity.Student;
import com.ragheb.entity.StudentCompositeKey;

public class Tester {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAOImpl();

        // save student
//        StudentCompositeKey key = new StudentCompositeKey();
//        key.setRollNumber(101);
//        key.setSection("A");
//
//        Student student = new Student();
//        student.setName("Ragheb");
//        student.setMarks(100);
//        student.setCompositeKey(key);
//
//        dao.saveStudent(student);

        // fetch student
        StudentCompositeKey key = new StudentCompositeKey();
        key.setSection("A");
        key.setRollNumber(101);

        Student student = dao.fetchStudent(key);
        System.out.println("name: " + student.getName());
        System.out.println("marks: " + student.getMarks());

    }
}
