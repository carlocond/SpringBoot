package Repository;

import Model.ETable;
import Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("""
            select r from Reservation r
            where r.tableEntity = :table
            and r.startTime < :endTime
            and r.endTime > :startTime
            """)
    List<Reservation> findOverlaps(ETable table,
                                   LocalDateTime startTime,
                                   LocalDateTime endTime);
}
