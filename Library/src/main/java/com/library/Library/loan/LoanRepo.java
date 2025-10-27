package com.library.Library.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepo extends JpaRepository<Loan, Long> {

    // Tutti i prestiti di un utente
    @Query("SELECT l FROM Loan l WHERE l.user.id = :userId AND l.returnDate IS NULL")
    List<Loan> getActiveLoansByUserId(@Param("userId") Long userId);

    // Tutti i prestiti non restituiti
    @Query("SELECT l FROM Loan l WHERE l.dueDate < CURRENT_DATE AND l.returnDate IS NULL")
    List<Loan> getOverdueLoans();

    // Prestiti attivi per un libro specifico
    @Query("SELECT l FROM Loan l WHERE l.book.id = :bookId AND l.returnDate IS NULL")
    List<Loan> getActiveLoansByBookId(@Param("bookId") Long bookId);
}
