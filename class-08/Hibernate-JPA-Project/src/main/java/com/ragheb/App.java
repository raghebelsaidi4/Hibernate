package com.ragheb;

import com.ragheb.dao.EmployeeDAO;
import com.ragheb.dao.impl.EmployeeDAOImpl;
import com.ragheb.entity.Employee;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create an instance of EmployeeService to test
        EmployeeDAO employeeService = new EmployeeDAOImpl();

        // Test saving a new employee
        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setSalary(5000.00);

        System.out.println("Saving new employee...");
        employeeService.saveEmployee(emp1);  // Save the employee
//
//        // Test loading the employee by ID
//        Employee loadedEmp = employeeService.loadEmployeeById(emp1.getEmployeeId());
//        if (loadedEmp != null) {
//            System.out.println("Loaded employee: " + loadedEmp.getName() + ", Salary: " + loadedEmp.getSalary());
//        } else {
//            System.out.println("Employee not found");
//        }
//
//        // Test updating the employee's salary
//        if (loadedEmp != null) {
//            System.out.println("Updating employee salary...");
//            loadedEmp = employeeService.updateEmployee(loadedEmp.getEmployeeId(), 6000.00);  // Update salary to 6000
//            System.out.println("Updated employee: " + loadedEmp.getName() + ", New Salary: " + loadedEmp.getSalary());
//        }
//
//        // Test deleting the employee by ID
//        if (loadedEmp != null) {
//            System.out.println("Deleting employee...");
//            employeeService.deleteEmployeeById(loadedEmp.getEmployeeId());
//            System.out.println("Employee deleted successfully");
    }
}


