package com.library.Library.loan;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Creazione prestito
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestParam Long userId, @RequestParam Long bookId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        Loan loan = loanService.createLoan(userId, bookId, dueDate);
        return ResponseEntity.ok(loan);
    }

    // Restituzione libro
    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
        Loan loan = loanService.returnBook(loanId);
        return ResponseEntity.ok(loan);
    }

    // Eliminare prestito
    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
        return ResponseEntity.noContent().build();
    }

    // Prestiti attivi di un utente
    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<Loan>> getActiveLoansByUser(@PathVariable Long userId) {
        List<Loan> loans = loanService.findActiveLoansByUser(userId);
        return ResponseEntity.ok(loans);
    }

    // Prestiti scaduti
    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {
        List<Loan> loans = loanService.findOverdueLoans();
        return ResponseEntity.ok(loans);
    }

}
