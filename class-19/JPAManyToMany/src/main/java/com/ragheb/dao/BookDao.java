package com.ragheb.dao;

import com.ragheb.entity.Book;

public interface BookDao {

    void saveBook(Book book);

    Book findBook(Integer bookId);

    void removeBook(Integer bookId);
}
