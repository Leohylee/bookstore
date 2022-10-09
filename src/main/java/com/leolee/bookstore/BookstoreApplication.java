package com.leolee.bookstore;

import com.leolee.bookstore.model.Author;
import com.leolee.bookstore.model.Book;
import com.leolee.bookstore.model.Publisher;
import com.leolee.bookstore.model.StockLevel;
import com.leolee.bookstore.repository.AuthorRepository;
import com.leolee.bookstore.repository.BookRepository;
import com.leolee.bookstore.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    // Just for testing purpose
    public CommandLineRunner mappingDemo(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        return args -> {

            // create new authors
            Author author1 = new Author("Leo", "Lee");
            Author author2 = new Author("Joanne", "Rowling");

            // create new publisher
            Publisher publisher = new Publisher("Penguin");

            // save publisher
            publisherRepository.save(publisher);

            // create new books
            Book book1 = new Book("1381234567897", "Three Little Pigs", new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime(), author1, publisher, new StockLevel(100));
            Book book2 = new Book("2222133267897", "Little Red Riding Hood", new GregorianCalendar(2002, Calendar.AUGUST, 22).getTime(), author1, publisher, new StockLevel(200));
            Book book3 = new Book("9123234567751", "Wolfs Coming!", new GregorianCalendar(1998, Calendar.NOVEMBER, 11).getTime(), author1, publisher, new StockLevel(300));
            Book book4 = new Book("5342432878620", "Harry Potter", new GregorianCalendar(1997, Calendar.JUNE, 26).getTime(), author2, publisher, new StockLevel(1000));

            // add books into authors
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);
            author2.addBook(book4);

            // save authors
            authorRepository.save(author1);
            authorRepository.save(author2);
        };
    }

}
