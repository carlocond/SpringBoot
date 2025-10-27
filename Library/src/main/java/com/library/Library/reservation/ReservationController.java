package com.library.Library.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    // Crea una prenotazione
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO request) {
        Reservation reservation = reservationService.createReservation(
                request.getUserId(),
                request.getBookId()
        );
        return ResponseEntity.ok(reservation);
    }

    // Cancella una prenotazione
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    // Tutte le prenotazioni di un utente
    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getReservationsByUser(userId);
        return ResponseEntity.ok(reservations);
    }

    // Tutte le prenotazioni di un libro
    @GetMapping("/com/library/Library/book/{bookId}")
    public ResponseEntity<List<Reservation>> getReservationsByBook(@PathVariable Long bookId) {
        List<Reservation> reservations = reservationService.getReservationsByBook(bookId);
        return ResponseEntity.ok(reservations);
    }

    //Controllo della scadenza di una prenotazione
    @GetMapping("/check-expired")
    public ResponseEntity<String> checkExpiredReservations() {
        reservationService.checkExpiredReservations();
        return ResponseEntity.ok("Controllo delle prenotazioni scadute completato");
    }
}
