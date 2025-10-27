package com.library.Library.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    List<Reservation> getByUserId(Long userId);
    List<Reservation> getByBookId(Long bookId);

}
