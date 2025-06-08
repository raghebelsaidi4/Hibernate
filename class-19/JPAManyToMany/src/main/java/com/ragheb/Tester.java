package com.ragheb;


import com.ragheb.dao.BookDao;
import com.ragheb.dao.impl.BookDaoImpl;
import com.ragheb.entity.Author;
import com.ragheb.entity.Book;

import java.util.Arrays;
import java.util.List;

public class Tester
{
    public static void main( String[] args )
    {
        BookDao dao = new BookDaoImpl();
//
//        // create book instance
//        Book b1 = new Book();
//        b1.setBookId(10);
//        b1.setBookName("Learn java");
//
//        Book b2 = new Book();
//        b2.setBookId(20);
//        b2.setBookName("Spring Framework");
//
//        // create author instance
//        Author a1 = new Author();
//        a1.setAuthorId(90);
//        a1.setAuthorName("Ragheb");
//
//        Author a2 = new Author();
//        a2.setAuthorId(80);
//        a2.setAuthorName("Ahmed");
//
//        Author a3 = new Author();
//        a3.setAuthorId(70);
//        a3.setAuthorName("Amr");
//
//        List<Author> authors_of_book1 = Arrays.asList(a1,a3);
//        b1.setAuthors(authors_of_book1);
//
//        List<Author> authors_of_book2 =  Arrays.asList(a1,a2,a3);
//        b2.setAuthors(authors_of_book2);
//
//        dao.saveBook(b1);
//        dao.saveBook(b2);

        // find books
//        Book book_from_db = dao.findBook(20);
//        System.out.println("Book id: "+book_from_db.getBookId());
//        System.out.println("Book name: "+book_from_db.getBookName());
//        List<Author> authors = book_from_db.getAuthors();
//        authors.forEach(System.out::println);

        // remove book
        dao.removeBook(30);
    }
}
