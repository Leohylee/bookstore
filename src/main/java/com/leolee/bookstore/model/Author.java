package com.leolee.bookstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", cascade=CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getfirstName() { return firstName; }
    public void setfirstName(String firstName) { this.firstName = firstName; }

    public String getlastName() { return lastName; }
    public void setlastName(String lastName) { this.lastName = lastName; }

    public void addBook(Book book) { books.add(book); }
    public void removeBooks(Book book) { books.remove(book); }
    public Set<Book> getBooks() { return books; }

    public Author() {}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
