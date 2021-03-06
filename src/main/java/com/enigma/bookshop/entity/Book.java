package com.enigma.bookshop.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_book")
public class Book {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)     // utk id
    @GeneratedValue(generator = "uuid2")     // utk uuid
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(32)")
    @Id
    private String uuid;
    private String title;
    private String description;
    private String publisher;
    private Integer year;
    private Integer page;
    private String language;
    private Integer stock;
    private Integer price;

    public Book() {
    }

    public Book(String uuid, String title, String description, String publisher, Integer year, Integer page, String language, Integer stock, Integer price) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.year = year;
        this.page = page;
        this.language = language;
        this.stock = stock;
        this.price = price;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
