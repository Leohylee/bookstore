package com.leolee.bookstore.repository;

import com.leolee.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // CRUD database methods

    Book findBookByIsbn(String isbn);

    List<Book> findBooksByTitleContains(String title);

    @Query("SELECT b FROM Book b JOIN b.author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<Book> findBooksByAuthor(String firstName, String lastName);

    @Query("SELECT b FROM Book b JOIN b.publisher p WHERE p.name = :publisher")
    List<Book> findBooksByPublisher(String publisher);
}
