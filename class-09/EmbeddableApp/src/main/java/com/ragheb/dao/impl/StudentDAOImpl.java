package com.ragheb.dao.impl;

import com.ragheb.dao.StudentDAO;
import com.ragheb.entity.Student;
import com.ragheb.entity.StudentCompositeKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class StudentDAOImpl implements StudentDAO {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void saveStudent(Student student) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(student);
            transaction.commit();
            System.out.println("Student saved successfully");
        }catch (Exception e) {
            transaction.rollback();
            System.out.println("Student save failed");
        }finally {
            em.close();
        }
    }

    @Override
    public Student fetchStudent(StudentCompositeKey compositeKey) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Student student = em.find(Student.class, compositeKey);
        transaction.commit();
        return student;
    }
}
