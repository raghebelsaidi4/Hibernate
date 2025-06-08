package com.ragheb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors" ,
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    )
    private List<Author> authors;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
