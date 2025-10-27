package com.library.Library.loan;

import com.library.Library.book.Book;
import com.library.Library.book.BookRepo;
import com.library.Library.book.BookStatus;
import org.springframework.stereotype.Service;
import com.library.Library.user.User;
import com.library.Library.user.UserRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepo loanRepo;
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public LoanService(LoanRepo loanRepo, UserRepo userRepo, BookRepo bookRepo) {
        this.loanRepo = loanRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    // Creazione prestito
    public Loan createLoan(Long userId, Long bookId, LocalDate dueDate) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro non trovato"));

        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new RuntimeException("Libro non disponibile");
        }

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStartDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setReturnDate(null);

        // Imposta lo status del libro come BORROWED
        book.setStatus(BookStatus.BORROWED);
        bookRepo.save(book);

        return loanRepo.save(loan);
    }

    // Restituzione libro
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Prestito non trovato"));

        if (loan.getReturnDate() != null) {
            throw new RuntimeException("Libro già restituito");
        }

        loan.setReturnDate(LocalDate.now());

        // Aggiorna lo status del libro a AVAILABLE
        Book book = loan.getBook();
        book.setStatus(BookStatus.AVAILABLE);
        bookRepo.save(book);

        return loanRepo.save(loan);
    }

    // Eliminare un prestito
    public void deleteLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Prestito non trovato"));
        loanRepo.delete(loan);
    }

    // Prestiti attivi di un utente
    public List<Loan> findActiveLoansByUser(Long userId) {
        return loanRepo.getActiveLoansByUserId(userId);
    }

    // Prestiti scaduti
    public List<Loan> findOverdueLoans() {
        return loanRepo.getOverdueLoans();
    }
}

