package com.ragheb.dao.impl;

import com.ragheb.dao.CategoryDao;
import entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CategoryDaoImpl implements CategoryDao {

    private EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void saveCategory(Category category) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            entityManager.persist(entityManager);
            tx.commit();
            System.out.println("Category with products are persisted into Database...");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Category fetchCategory(Integer categoryId) {
        EntityManager entityManager = factory.createEntityManager();
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.close();
        return category;
    }

    @Override
    public void removeCategory(Integer categoryId) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        Category category = entityManager.find(Category.class, categoryId);
        tx.begin();
        try {
            entityManager.remove(category);
            tx.commit();
            System.out.println("Category with products is removed from Database");
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
