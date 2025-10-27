package com.library.Library.user;

import com.library.Library.loan.Loan;
import com.library.Library.loan.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final LoanRepo loanRepo;

    @Autowired
    public UserService(UserRepo userRepo, LoanRepo loanRepo){
        this.userRepo = userRepo;
        this.loanRepo = loanRepo;
    }

    public User findUserByEmail(String email){
        return userRepo.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Nessun utente trovato con indirizzo email: " + email));
    }

    // Trova user in base al ruolo (Admin o User)
    public List<User> findUsersByRole(UserRole userRole) {
        return userRepo.getUserByRole(userRole);
    }

    // Trova user in base allo status (Attivo o Sospeso)
    public List<User> findUserByStatus(UserStatus userStatus) {
        return userRepo.getUserByStatus(userStatus);
    }

    public User findUserById(Long id){
        return userRepo.getUserById(id)
                .orElseThrow(() -> new RuntimeException("Nessun utente trovato con id: " + id));
    }

    //Create Update e Delete

    // Create con controllo di esistenza
    public User createUser(User user) {
        if (userRepo.getUserByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email già in uso");
        }
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(UserRole.USER);
        return userRepo.save(user);
    }

    // Update dello status con controllo di esistenza
    public User changeUserStatus(Long id, UserStatus newStatus) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (newStatus == UserStatus.SUSPENDED) {
            List<Loan> activeLoans = loanRepo.getActiveLoansByBookId(id);
            if (!activeLoans.isEmpty()) {
                throw new RuntimeException("Non puoi sospendere un utente con prestiti attivi");
            }
        }

        user.setStatus(newStatus);
        return userRepo.save(user);
    }

    // Update con controllo di esistenza
    public User updateUser(Long id, User userDetails) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        user.setfName(userDetails.getfName());
        user.setlName(userDetails.getlName());
        user.setEmail(userDetails.getEmail());

        return userRepo.save(user);
    }

    // Delete tramite id e controllo di esistenza
    public void deleteUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        userRepo.delete(user);
    }

}
