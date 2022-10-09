package com.leolee.bookstore.controller;

import com.leolee.bookstore.model.Author;
import com.leolee.bookstore.model.Book;
import com.leolee.bookstore.model.Publisher;
import com.leolee.bookstore.model.StockLevel;
import com.leolee.bookstore.repository.AuthorRepository;
import com.leolee.bookstore.repository.BookRepository;
import com.leolee.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookRepository.findBooksByTitleContains(title);
    }

    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String firstName, @RequestParam String lastName) {
        return bookRepository.findBooksByAuthor(firstName, lastName);
    }

    @GetMapping("/publisher/{publisher}")
    public List<Book> getBooksByAuthor(@PathVariable String publisher) {
        return bookRepository.findBooksByPublisher(publisher);
    }

    @PutMapping("/authorId/{authorId}/publisherId/{publisherId}")
    public ResponseEntity createBook(@PathVariable long authorId, @PathVariable long publisherId, @RequestBody Book book) {
        Author author = authorRepository.getReferenceById(authorId);
        Publisher publisher = publisherRepository.getReferenceById(publisherId);
        if (Objects.nonNull(author) && Objects.nonNull(publisher)) {
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setStocklevel(new StockLevel(0));
            bookRepository.save(book);
            return ResponseEntity.ok("Book added successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable long id, @RequestBody Book bookInfo) {
        Book book = bookRepository.findById(id).get();
        book.setIsbn(bookInfo.getIsbn());
        book.setPublishDate(bookInfo.getPublishDate());
        book.setTitle(bookInfo.getTitle());
        bookRepository.save(book);
        return ResponseEntity.ok("Book updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok(String.format("Book (id: %d) deleted!", id));
    }
}
