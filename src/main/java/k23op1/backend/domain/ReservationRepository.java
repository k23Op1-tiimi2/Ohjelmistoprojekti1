package k23op1.backend.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    // List<Reservation> findAll();
    // List<Reservation> findByReservation(Reservation reservation);
}
