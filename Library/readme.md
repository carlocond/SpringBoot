# 📚 Library Management System – Spring Boot Project

Un progetto backend completo per la **gestione di una biblioteca**, sviluppato in **Java Spring Boot**.  
L’obiettivo è realizzare un sistema basato su un’architettura a tre livelli (**Controller, Service, Repository**).

---

## 🚀 Obiettivi del progetto
Questo progetto è parte del mio percorso di apprendimento e approfondimento su **Spring Boot** e sulle architetture RESTful.  
L’idea è di gestire tutti gli aspetti principali di una biblioteca digitale: utenti, libri, autori, prestiti e prenotazioni, applicando logiche di business reali e una struttura modulare.

---

Il progetto è open source e in continua evoluzione.
Chiunque voglia dare suggerimenti, migliorare il codice o aggiungere nuove funzionalità è il benvenuto!
📩 Sentiti libero di aprire una pull request o creare una issue con le tue proposte.

---

## 🧩 Funzionalità principali

### 👤 Gestione Utenti
- Creazione, aggiornamento e cancellazione utenti
- Gestione di **ruoli** (USER, ADMIN) e **stati** (ATTIVO, SOSPESO)
- Regole di business per sospensioni e permessi
- Endpoint dedicati per filtri e ricerche (es. utenti attivi o admin)

### 📚 Gestione Libri e Autori
- Creazione e gestione di libri e autori con relazioni bidirezionali
- Ricerca di libri per nome autore o titolo
- Aggiornamento dello stato dei libri (disponibile, prestato, riservato)

### 💳 Gestione Prestiti (Loan)
- Creazione prestiti con controllo scadenze
- Ricerca dei prestiti attivi di un utente
- Validazioni per impedire nuovi prestiti a utenti sospesi
- Restituzione automatica o manuale dei libri

### 🕒 Gestione Prenotazioni (Reservation)
- Possibilità di prenotare libri già presi in prestito
- Sistema di **coda** per gestire le prenotazioni multiple
- Controllo giornaliero automatico con **@Scheduled** per rimuovere prenotazioni scadute

---

## ⚙️ Tecnologie utilizzate
- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Scheduling
- **H2 Database** (per sviluppo e test)
- **Maven** come build tool
- **REST API** per l’interazione con il sistema

---

## 🧱 Architettura del progetto
src/
└── main/
├── java/
│ ├── user/ → Gestione utenti (Controller, Service, Repository)
│ ├── book/ → Gestione libri
│ ├── author/ → Gestione autori
│ ├── loan/ → Gestione prestiti
│ └── reservation/ → Gestione prenotazioni
└── resources/
├── application.properties
└── static/ → (eventuale frontend HTML/JS)


**Struttura a tre livelli:**
- **Controller:** gestisce le richieste HTTP (GET, POST, PUT, DELETE)
- **Service:** applica la logica di business e le regole del dominio
- **Repository:** interagisce con il database tramite JPA

---

## ▶️ Come eseguire il progetto
mvn spring-boot:run

### 1️⃣ Clona il repository
```bash
git clone https://github.com/carlocond/library.git
cd library
