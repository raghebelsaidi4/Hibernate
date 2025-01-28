package com.ragheb.client;

import com.ragheb.dao.StudentDAO;
import com.ragheb.dao.impl.StudentDAOImpl;
import com.ragheb.entity.Student;

/**
 * Hello world!
 *
 */
public class Tester
{
    public static void main( String[] args )
    {
        StudentDAO dao = new StudentDAOImpl();
        Student student = new Student();

        // Save a new student
//        student.setId(11);
//        student.setName("Ragheb");
//        student.setGender("Male");
//        student.setMarks(6000);
//        dao.saveStudent(student);
//        System.out.println("Student saved: " + student);

        // Load a student by ID
//        Student loadedStudent = dao.loadStudent(11);
//        if (loadedStudent != null) {
//            System.out.println("Loaded Student: " + loadedStudent);
//        } else {
//            System.out.println("Student not found.");
//        }

        // Update a student's marks
//        Student updatedStudent = dao.updateStudent(11, 9000);
//        if (updatedStudent != null) {
//            System.out.println("Updated Student: " + updatedStudent);
//        } else {
//            System.out.println("Failed to update student.");
//        }

        // Delete a student
//        dao.deleteStudent(11);
//        System.out.println("Student deleted.");
    }
}
