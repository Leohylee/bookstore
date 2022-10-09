package com.leolee.bookstore.repository;

import com.leolee.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    // CRUD database methods
}
