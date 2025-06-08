package com.ragheb;

import com.ragheb.dao.LoanDao;
import com.ragheb.dao.impl.LoanDaoImpl;
import com.ragheb.entity.Customer;
import com.ragheb.entity.Loan;

public class Tester
{
    public static void main( String[] args )
    {
        LoanDao dao = new LoanDaoImpl();

        // invoke saveLoan()
//        Loan loan = new Loan();
//        loan.setId(30);
//        loan.setLoanType("Personal Loan");
//        loan.setAmount(50000.0);
//
//        Loan loan2 = new Loan();
//        loan2.setId(34);
//        loan2.setLoanType("Vehicle Loan");
//        loan2.setAmount(110000.0);
//
//        Loan loan3 = new Loan();
//        loan3.setId(37);
//        loan3.setLoanType("Home Loan");
//        loan3.setAmount(330000.0);
//
//        Customer customer = new Customer();
//        customer.setName("A");
//        customer.setId(101);
//
//        loan.setCustomer(customer);
//        loan2.setCustomer(customer);
//        loan3.setCustomer(customer);
//
//        dao.saveLoan(loan);
//        dao.saveLoan(loan2);
//        dao.saveLoan(loan3);


        // fetch Loan Details By ID
//        Loan l = dao.fetchLoanDetailsById(30);
//        System.out.println(l);
//        Customer c = l.getCustomer();
//        System.out.println(c);

        // Remove Loan
        dao.removeLoan(30);
    }
}
