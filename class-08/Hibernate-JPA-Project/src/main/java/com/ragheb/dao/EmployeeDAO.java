package com.ragheb.dao;

import com.ragheb.entity.Employee;

public interface EmployeeDAO {

    void saveEmployee(Employee emp);

    Employee loadEmployeeById(Integer EmpId);

    Employee updateEmployee(Integer EmpId, Double newSalary);

    void deleteEmployeeById(Integer EmpId);
}
