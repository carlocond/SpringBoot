package Controller;

import Model.ETable;
import Model.Reservation;
import Repository.ReservationRepository;
import Repository.TableRepository;
import dto.ReservationRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;
    private final TableRepository tableRepository;

    public ReservationController(ReservationService reservationService, ReservationRepository reservationRepository, TableRepository tableRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
        this.tableRepository = tableRepository;
    }

    @GetMapping("/tables")
    public List<ETable> eTableList() {
        return tableRepository.findAll();
    }

    @PostMapping("/tables")
    @ResponseStatus(HttpStatus.CREATED)
    public ETable createTable(@RequestBody ETable table){
        if (table.getSeats() < 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "I posti a sedere devono essere almeno 1");
        return tableRepository.save(table);
    }

    @GetMapping("/reservations")
    public List<Reservation> reservationList() {
        return reservationRepository.findAll();
    }

    @PostMapping("/reservations")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@Valid @RequestBody ReservationRequest request){
        return reservationService.createReservation(request);
    }
}
