package com.ragheb.dao.impl;

import com.ragheb.dao.EmployeeDAO;
import com.ragheb.entity.EmployeeEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public List<EmployeeEntity> executeNamedQuery(int deptNo) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<EmployeeEntity> query = em.createNamedQuery("query1", EmployeeEntity.class);
        query.setParameter(1, deptNo);
        List<EmployeeEntity> employeeEntityList = query.getResultList();
        em.close();
        return employeeEntityList;
    }

    @Override
    public List executeNamedNativeQuery(int sal) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("query2");
        query.setParameter("sal", sal);
        List<EmployeeEntity> employeeEntityList = query.getResultList();
        em.close();
        return employeeEntityList;
    }

    @Override
    public List<EmployeeEntity> executeCriteriaQuery() {
        EntityManager em = factory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> cq = cb.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = cq.from(EmployeeEntity.class);
        cq.select(root);
        TypedQuery<EmployeeEntity> query = em.createQuery(cq);
        List<EmployeeEntity> employeeEntityList = query.getResultList();
        em.close();
        return employeeEntityList;
    }
}
