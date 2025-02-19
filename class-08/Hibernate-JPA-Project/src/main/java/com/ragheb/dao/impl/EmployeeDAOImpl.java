package com.ragheb.dao.impl;

import com.ragheb.dao.EmployeeDAO;
import com.ragheb.entity.Employee;

import javax.persistence.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void saveEmployee(Employee emp) {
        // Try-with-resources for automatic closing of EntityManager
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.persist(emp);  // Save new employee to DB
            tx.commit();
            System.out.println("Employee saved successfully");
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();  // Rollback transaction on error
            }
            System.out.println("Error in inserting employee: " + e.getMessage());
        } finally {
            entityManager.close();  // Ensure the entity manager is always closed
        }
    }

    @Override
    public Employee loadEmployeeById(Integer EmpId) {
        EntityManager entityManager = factory.createEntityManager();
        Employee emp = null;

        try {
            /*
             * find() -> eager loading: fetches the entity immediately
             * getReference() -> lazy loading: fetches the entity when it is accessed
             */
            emp = entityManager.find(Employee.class, EmpId);  // Eager loading by default
        } catch (Exception e) {
            System.out.println("Error loading employee: " + e.getMessage());
        } finally {
            entityManager.close();  // Ensure the entity manager is always closed
        }

        return emp;
    }

    @Override
    public Employee updateEmployee(Integer EmpId, Double newSalary) {
        EntityManager entityManager = factory.createEntityManager();
        Employee emp = null;

        try {
            emp = entityManager.find(Employee.class, EmpId);
            if (emp != null) {
                emp.setSalary(newSalary);  // Update salary
                entityManager.getTransaction().begin();
                entityManager.merge(emp);  // Use merge() for updating
                entityManager.getTransaction().commit();
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("Employee not found for id: " + EmpId);
            }
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        } finally {
            entityManager.close();  // Ensure the entity manager is always closed
        }

        return emp;
    }

    @Override
    public void deleteEmployeeById(Integer EmpId) {
        EntityManager entityManager = factory.createEntityManager();

        try {
            Employee emp = entityManager.find(Employee.class, EmpId);
            if (emp != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(emp);  // Delete employee from DB
                entityManager.getTransaction().commit();
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee not found for id: " + EmpId);
            }
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        } finally {
            entityManager.close();  // Ensure the entity manager is always closed
        }
    }
}
