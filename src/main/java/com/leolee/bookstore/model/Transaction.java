package com.leolee.bookstore.model;

import javax.persistence.*;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String customerName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column
    private int qty;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getBook() { return book.getTitle(); }
    public void setBook(Book book) { this.book = book; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public Transaction() {}

    public Transaction(String customerName, Book book, int qty) {
        this.customerName = customerName;
        this.book = book;
        this.qty = qty;
    }

}
