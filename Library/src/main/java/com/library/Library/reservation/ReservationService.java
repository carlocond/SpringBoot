package com.library.Library.reservation;

import com.library.Library.book.Book;
import com.library.Library.book.BookRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.library.Library.user.User;
import com.library.Library.user.UserRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepo reservationRepo;
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public ReservationService(ReservationRepo reservationRepo,
                              UserRepo userRepo,
                              BookRepo bookRepo) {
        this.reservationRepo = reservationRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    //Create e delete

    //Create
    public Reservation createReservation(Long userId, Long bookId){
        User user = userRepo.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Book book = bookRepo.getBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro non trovato"));

        int queuePos = reservationRepo.getByBookId(bookId).size() + 1;

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDate.now());
        reservation.setExpirationDate(LocalDate.now().plusDays(3)); //Scadenza dopo 3 giorni
        reservation.setQueuePos(queuePos);
        reservation.setStatus(ReservationStatus.ACTIVE);

        return reservationRepo.save(reservation);
    }

    //Delete
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepo.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Prenotazione non trovata"));
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepo.save(reservation);
    }

    public List<Reservation> getReservationsByUser(Long userId) {
        return reservationRepo.getByUserId(userId);
    }

    public List<Reservation> getReservationsByBook(Long bookId) {
        return reservationRepo.getByBookId(bookId);
    }

    //Controllo delle prenotazioni scadute
    public void checkExpiredReservations() {
        List<Reservation> activeReservations = reservationRepo.findAll(); //Controlla dal db
        for (Reservation res : activeReservations) { //Scorre tutte le prenotazioni attive
            if (res.getStatus() == ReservationStatus.ACTIVE && //Se lo stato è attivo e la data di scadenza è prima di "oggi" la pren. è scaduta
                    res.getExpirationDate().isBefore(LocalDate.now())) {
                res.setStatus(ReservationStatus.EXPIRED); //Imposta la prenotazione su scaduta
                reservationRepo.save(res); //Salva la prenotazione aggiornata
            }
        }
    }
    //Controllo che avviene ogni giorno alle 00:00
    @Scheduled(cron = "0 0 0 * * ?") // 0 secondo 0 minuto 0 ora * giorno * mese ? qualsiasi giorno della settimana
    public void dailyReservationCheck() {
        checkExpiredReservations();
    }
}
