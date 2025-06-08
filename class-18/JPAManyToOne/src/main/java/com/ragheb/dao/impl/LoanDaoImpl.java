package com.ragheb.dao.impl;

import com.ragheb.dao.LoanDao;
import com.ragheb.entity.Loan;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LoanDaoImpl implements LoanDao {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void saveLoan(Loan loan) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            entityManager.merge(loan);
            tx.commit();
            System.out.println("Laon object is persisted successfully");
        }catch (Exception e){
                tx.rollback();
                e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Loan fetchLoanDetailsById(Integer loanId) {
        EntityManager entityManager = factory.createEntityManager();
        Loan loan = entityManager.find(Loan.class, loanId);
        entityManager.close();
        return loan;
    }

    @Override
    public void removeLoan(Integer loanId) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            Loan loan = entityManager.find(Loan.class, loanId);
            entityManager.remove(loan);
            tx.commit();
            System.out.println("Loan object is deleted");
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
