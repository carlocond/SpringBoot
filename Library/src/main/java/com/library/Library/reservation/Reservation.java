package com.library.Library.reservation;

import com.library.Library.book.Book;
import jakarta.persistence.*;
import com.library.Library.user.User;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate reservationDate;
    private LocalDate expirationDate;
    private int queuePos;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation(LocalDate reservationDate, int queuePos) {
        this.reservationDate = LocalDate.now();
    }

    public Reservation(Long id, Book book, User user, LocalDate reservationDate, int queuePos) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.reservationDate = LocalDate.now();
        this.queuePos = queuePos;
    }

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQueuePos() {
        return queuePos;
    }

    public void setQueuePos(int queuePos) {
        this.queuePos = queuePos;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
