package k23op1.backend.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    // List<Reservation> findByCustName(List<Reservation> reservations);
    // List<Reservation> findAll();
    // List<Reservation> findByReservation(Reservation reservation);

    // List<Reservation> findById();

    // List<Reservation> findByReservationId();

    Reservation findByReservationId(Long reservationId);

}
