package com.library.Library.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER; //Ruolo di default

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE; // Stato di default

    private LocalDate registrationDate;

    //Costruttore che accetta i parametri delle condizioni di default dell'user
    public User(LocalDate registrationDate, UserStatus status, UserRole role) {
        this.registrationDate = LocalDate.now();
        this.status = UserStatus.ACTIVE;
        this.role = UserRole.USER;
    }

    //Costruttore parametrizzato
    public User(Long id, String fName, String lName, String email, UserRole role, UserStatus status, LocalDate registrationDate) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.registrationDate = LocalDate.now();
    }

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
