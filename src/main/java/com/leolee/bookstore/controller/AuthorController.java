package com.leolee.bookstore.controller;

import com.leolee.bookstore.model.Author;
import com.leolee.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id).get();
    }

    @GetMapping("/name")
    public List<Author> getAuthorsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam("lastName") String lastName) {
        return authorRepository.findAuthorsByFirstNameAndLastName(firstName, lastName);
    }

    @PutMapping
    public ResponseEntity createAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return ResponseEntity.ok("Author created successfully!");
    }

    @PostMapping("/{id}")
    public ResponseEntity updateAuthor(@PathVariable long id, @RequestBody Author authorInfo) {
        Author author = authorRepository.getReferenceById(id);
        author.setfirstName(authorInfo.getfirstName());
        author.setlastName(authorInfo.getlastName());
        authorRepository.save(author);
        return ResponseEntity.ok("Author updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthorById(@PathVariable long id) {
        authorRepository.deleteById(id);
        return ResponseEntity.ok(String.format("Author (id: %d) deleted!", id));
    }

}
