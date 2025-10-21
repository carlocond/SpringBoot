# University Student Management

Applicazione back-end per la gestione degli studenti universitari, sviluppata con **Spring Boot** e **PostgreSQL**.

## Funzionalità

- Visualizzazione della lista studenti con dettagli: nome, cognome, età, corso, CFU ed esami.
- Filtraggio per nome, cognome o corso.
- Aggiunta di nuovi studenti.
- Modifica dei dati degli studenti esistenti.
- Eliminazione degli studenti dal database.
- Backend sviluppato con Spring Boot e JPA/Hibernate.

## Tecnologie

- Java 17
- Spring Boot
- PostgreSQL
- JPA / Hibernate

## Avvio del progetto

1. Avvia il database PostgreSQL e crea il database `university_db` con l’utente configurato.  
2. Avvia l’applicazione Spring Boot:
```bash
./mvnw spring-boot:run
