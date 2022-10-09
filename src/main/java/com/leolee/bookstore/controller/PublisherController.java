package com.leolee.bookstore.controller;

import com.leolee.bookstore.model.Publisher;
import com.leolee.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/all")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable long id) {
        return publisherRepository.findById(id).get();
    }

    @PostMapping("/{id}")
    public ResponseEntity updatePublisher(@PathVariable long id, @RequestBody Publisher publisherInfo) {
        Publisher publisher = publisherRepository.getReferenceById(id);
        publisher.setName(publisherInfo.getName());
        publisherRepository.save(publisher);
        return ResponseEntity.ok("Publisher updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePublisherById(@PathVariable long id) {
        publisherRepository.deleteById(id);
        return ResponseEntity.ok(String.format("Publisher (id: %d) deleted!", id));
    }

    @PutMapping
    public ResponseEntity createPublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        return ResponseEntity.ok("Publisher created successfully!");
    }

}

