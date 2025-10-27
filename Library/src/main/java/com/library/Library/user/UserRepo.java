package com.library.Library.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> getUserByEmail(String email);
    List<User> getUserByRole(UserRole userRole);
    List<User> getUserByStatus(UserStatus userStatus);
    Optional<User> getUserById(Long id);

}
