package com.leolee.bookstore.model;

import javax.persistence.*;

@Entity
@Table
public class StockLevel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "stocklevel")
    private Book book;

    @Column
    private int qty = 0;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public StockLevel() {}

    public StockLevel(int qty) { this.qty = qty; }

}
