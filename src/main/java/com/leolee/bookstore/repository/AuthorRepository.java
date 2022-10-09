package com.leolee.bookstore.repository;

import com.leolee.bookstore.model.Author;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // CRUD database methods

    List<Author> findAuthorsByFirstNameAndLastName(@NotNull String firstName, @NotNull String lastName);
}
