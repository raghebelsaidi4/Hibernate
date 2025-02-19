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
//        System.out.println(dao.executeNamedQuery(1));

//        List list = dao.executeNamedNativeQuery(3000);
//        list.forEach(System.out::println);

//        System.out.println(dao.executeCriteriaQuery());
    }
}
