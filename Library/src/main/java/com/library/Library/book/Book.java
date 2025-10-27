package com.library.Library.book;


import com.library.Library.author.Author;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publisher;
    private LocalDate publicationDate;
    private int pages;
    private double price;
    private String genre;
    private String language;
    private String description;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.AVAILABLE; //Valore di default

    @ManyToOne //Tipo di relazione nel database tra libri e autori, più libri possono appartenere ad un autore
    @JoinColumn(name = "author_id")
    private Author author;

    //Costruttore di default
    public Book() {
        //Impostazione automatica del libro disponibile
        this.status = BookStatus.AVAILABLE;
    }



    //Costruttore parametrizzato
    public Book(Long id, String title, String publisher, LocalDate publicationDate, int pages, double price, String genre, String language, String description, String isbn, BookStatus status, Author author) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.price = price;
        this.genre = genre;
        this.language = language;
        this.description = description;
        this.isbn = isbn;
        this.status = BookStatus.AVAILABLE;
        this.author = author;
    }


    //Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
