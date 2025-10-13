package service;

import Model.ETable;
import Model.Reservation;
import Repository.ReservationRepository;
import Repository.TableRepository;
import dto.ReservationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TableRepository tableRepository;

    public ReservationService(ReservationRepository reservationRepository, TableRepository tableRepository) {
        this.reservationRepository = reservationRepository;
        this.tableRepository = tableRepository;
    }

    @Transactional
    public Reservation createReservation(ReservationRequest request) {
        if (!request.getEndTime().isAfter(request.getStartTime())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il tempo di conclusione deve essere dopo quello d'inizio");
        }
        Duration duration = Duration.between(request.getStartTime(), request.getEndTime());
        if (duration.toMinutes() < 30){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La prenotazione deve essere di almeno 30 minuti");
        }
        ETable table = tableRepository.findById(request.getTableId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tavolo non trovato"));

        if (request.getSeatSize() > table.getSeats()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "I posti richiesti superano la capacità del tavolo");
        }

        List<Reservation> overlaps = reservationRepository.findOverlaps(
                table, request.getStartTime(), request.getEndTime()
        );

        if (!overlaps.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Orario non disponibile per questo tavolo");
        }

        Reservation r = new Reservation();
        r.setCustomerName(request.getCustomerName());
        r.setCustomerPhone(request.getCustomerPhone());
        r.setSeatSize(request.getSeatSize());
        r.setStartTime(request.getStartTime());
        r.setEndTime(request.getEndTime());
        r.setTableEntity(table);

        return reservationRepository.save(r);

    }
}
