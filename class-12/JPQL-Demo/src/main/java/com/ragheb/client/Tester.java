package com.ragheb.client;

import com.ragheb.dao.EmployeeDAO;
import com.ragheb.dao.impl.EmployeeDAOImpl;
import com.ragheb.entity.EmployeeEntity;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Tester
{
    public static void main( String[] args )
    {
        EmployeeDAO dao = new EmployeeDAOImpl();

        //selecting a single employee
//        EmployeeEntity employeeEntity = dao.fetchEmployeeById(1);
//        System.out.println(employeeEntity);

        // selecting all employee
//        List<EmployeeEntity> entityList = dao.fetchAllEmployee();
//        System.out.println(entityList.toString());

//        List<Object[]> list = dao.fetchNamesAndSalaries();
//        list.forEach(obj -> System.out.println(obj[0] + " " + obj[1]));
    }
}
