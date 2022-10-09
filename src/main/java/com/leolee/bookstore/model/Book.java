package com.leolee.bookstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(name = "publish_date", nullable = false)
    @Temporal(DATE)
    @JsonFormat(pattern="yyyy/MM/dd")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "stocklevel_id", referencedColumnName = "id")
    private StockLevel stocklevel;

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getIsbn() { return isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getPublishDate() { return publishDate; }
    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }

    public String getAuthor() { return author.getfirstName() + " " + author.getlastName(); }
    public void setAuthor(Author author) { this.author = author; }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }

    public int getStocklevel() { return stocklevel.getQty(); }

    public void setStocklevel(StockLevel stocklevel) { this.stocklevel = stocklevel; }

    public Book() {}

    public Book(String isbn, String title, Date publishDate, Author author, Publisher publisher, StockLevel stockLevel) {
        this.isbn = isbn;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.publisher = publisher;
        this.stocklevel = stockLevel;
    }

}
