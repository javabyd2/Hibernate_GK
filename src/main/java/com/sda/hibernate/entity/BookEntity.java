package com.sda.hibernate.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "books")

public class BookEntity {

    @Column(name="title",nullable=false,length=128)
    private String title;

    @Column(name="author",nullable=false,length=128)
    private String author;

    @Column(name="published")
    private Date published;

    @Column(name="isbn", length=20)
    private String isbn;

    @Column(name="category",length=128)
    private String category;

    @Column(name="pageCount")
    private Integer pageCount;

    @Column(name="publisher",length=255)
    private String publisher;

    @Column(name="onStock",length=5)
    private Integer onStock;

    @Column(name="price",precision = 2)
    private BigDecimal price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOnStock() {
        return onStock;
    }

    public void setOnStock(Integer onStock) {
        this.onStock = onStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}




