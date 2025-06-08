package com.ragheb.dao.impl;

import com.ragheb.dao.BookDao;
import com.ragheb.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");

    @Override
    public void saveBook(Book book) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            entityManager.persist(book);
            tx.commit();
            System.out.println("Book is inserted ...");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Book findBook(Integer bookId) {
        EntityManager entityManager = factory.createEntityManager();
        Book book = entityManager.find(Book.class, bookId);
        entityManager.close();
        return book;
    }

    @Override
    public void removeBook(Integer bookId) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            Book book = entityManager.find(Book.class, bookId);
            tx.commit();
            System.out.println("Book is deleted ...");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
