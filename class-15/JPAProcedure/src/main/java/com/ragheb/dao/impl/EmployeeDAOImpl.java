package com.ragheb.dao.impl;

import com.ragheb.dao.EmployeeDAO;

import javax.persistence.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void executeProcedure(int empNo) {
        EntityManager entityManager = factory.createEntityManager();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pro1");
        query.setParameter("ENO", empNo);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.execute();
        String s1 = (String) query.getOutputParameterValue("NAME");
        double d = (Double) query.getOutputParameterValue("EXPERIENCE");
        tx.commit();
        System.out.println("Name: "+s1);
        System.out.println("EXPERIENCE: "+d);
        entityManager.close();
        factory.close();
    }
}
