package k23op1.backend.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import k23op1.backend.domain.Reservation;
import k23op1.backend.domain.ReservationRepository;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    // Tilaukset
    @RequestMapping(value = "/reservationlist", method = RequestMethod.GET)
    public String reservationList(Model model) {
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "reservationlist";
    }

    @GetMapping("/reservationdetails/{id}")
    public String showReservationDetails(@PathVariable("id") long reservationId, Model model) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + reservationId));
        model.addAttribute("reservation", reservation);
        // model.addAttribute("reservation",
        // (reservationRepository.findById(reservationId)).get());
        if (reservation.isDelivered()) {
            reservation.setStatus("DELIVERED");
        } else if (reservation.isCancelled()) {
            reservation.setStatus("CANCELLED");
        } else {
            reservation.setStatus("PENDING");
        }
        return "reservationdetails";
    }

    @PostMapping("/reservationdetails/{id}")
    public String updateReservationStatus(@PathVariable("id") Long reservationId,
            @ModelAttribute("reservation") Reservation reservation) {

        Reservation.updateReservationStatus(reservationId, reservation.getStatus());

        return "redirect:/reservationdetails/{id}";
    }

    @RequestMapping(value = "/deleteReservation/{reservationId}", method = RequestMethod.GET)
    public String deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationRepository.deleteById(reservationId);
        return "redirect:/reservationlist";
    }

}
