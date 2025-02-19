package com.ragheb.dao;

import com.ragheb.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {

    List<EmployeeEntity> executeNamedQuery(int deptNo);
    List executeNamedNativeQuery(int sal);
}
