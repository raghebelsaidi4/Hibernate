package com.ragheb.dao;

import com.ragheb.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {

    EmployeeEntity fetchEmployeeById(Integer empNo);

    List<EmployeeEntity> fetchAllEmployee();

    List<Object[]> fetchNamesAndSalaries();
}
