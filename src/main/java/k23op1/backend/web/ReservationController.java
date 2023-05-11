package k23op1.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;
import k23op1.backend.domain.Reservation;
import k23op1.backend.domain.ReservationRepository;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ProductRepository productRepository;

    // Tilaukset
    @RequestMapping(value = "/reservationlist", method = RequestMethod.GET)
    public String reservationList(Model model) {
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "reservationlist";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String showReservation(@PathVariable("id") Long reservationId, Model model) {

        model.addAttribute("reservation", (reservationRepository.findById(reservationId)).get());
        return "reservation";

    }

    @RequestMapping(value = "/reservationdetails", method = RequestMethod.GET)
    public String reservationByCustomer(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        // model.addAttribute("reservation",
        // (reservationRepository.findById(reservationId)).get());
        model.addAttribute("products", products);
        model.addAttribute("reservations", reservations);
        return "reservationdetails";
    }

    /*
     * @GetMapping("/reservationdetails/{id}")
     * public String getReservationsByCustomer(@PathVariable("id") Long id, Model
     * model) {
     * List<Product> products = (List<Product>) productRepository.findAll();
     * Reservation reservation = reservationRepository.findById(id)
     * .orElseThrow(() -> new IllegalArgumentException("Invalid Reservation Id:" +
     * id));
     * List<Reservation> reservations =
     * reservationRepository.findByReservation(reservation);
     * model.addAttribute("products", products);
     * model.addAttribute("reservations", reservations);
     * return "reservationdetails";
     * }
     */
}
