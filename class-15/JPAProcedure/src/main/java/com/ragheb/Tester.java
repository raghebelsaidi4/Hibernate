package com.ragheb;


import com.ragheb.dao.EmployeeDAO;
import com.ragheb.dao.impl.EmployeeDAOImpl;

import java.util.Scanner;

public class Tester
{
    public static void main( String[] args )
    {
        EmployeeDAO dao = new EmployeeDAOImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee number : ");
        int empNo = scanner.nextInt();
        dao.executeProcedure(empNo);
    }
}
