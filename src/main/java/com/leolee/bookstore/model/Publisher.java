package com.leolee.bookstore.model;

import javax.persistence.*;

@Entity
@Table
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public Publisher() {}

    public Publisher(String name) {
        this.name = name;
    }
}
