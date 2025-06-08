package com.ragheb.dao.impl;

import com.ragheb.constant.AppConstants;
import com.ragheb.dao.EmployeeDAO;
import com.ragheb.entity.EmployeeEntity;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public EmployeeEntity fetchEmployeeById(Integer empNo) {
        EntityManager em = factory.createEntityManager();
        try {
            TypedQuery<EmployeeEntity> typedQuery = em.createQuery(AppConstants.QUERY1, EmployeeEntity.class);
            typedQuery.setParameter("empNo", empNo);
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }


    @Override
    public List<EmployeeEntity> fetchAllEmployee() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<EmployeeEntity> typedQuery = em.createQuery(AppConstants.QUERY2, EmployeeEntity.class);
        List<EmployeeEntity> employeeList = typedQuery.getResultList();
        em.close();
        return employeeList;
    }

    @Override
    public List<Object[]> fetchNamesAndSalaries() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Object[]> typedQuery = em.createQuery(AppConstants.QUERY3, Object[].class);
        List<Object[]> employeeList = typedQuery.getResultList();
        em.close();
        return employeeList;
    }

}
