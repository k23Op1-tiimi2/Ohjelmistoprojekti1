package k23op1.backend.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;
import k23op1.backend.domain.Reservation;
import k23op1.backend.domain.ReservationRepository;

@Controller
public class ReservationController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

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

    @GetMapping("/reservationdetails/{id}")
    public String showReservationDetails(@PathVariable("id") long reservatioId, Model model) {
        Reservation reservation = reservationRepository.findById(reservatioId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + reservatioId));
        model.addAttribute("reservation", reservation);
        // model.addAttribute("reservation",
        // (reservationRepository.findById(reservationId)).get());
        return "reservationdetails";
    }

    JButton button = new JButton("Button");

    @PostMapping("/reserve")
    public String reserve(@RequestParam("status") String status) {
        // Do something with the status here
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Cancelled")) {
                    button.setText("Cancelled");
                    log.info("Cancelled");
                    // Send a POST request to the "/reserve" endpoint with a status of "reserved"
                } else {
                    button.setText("Delivered");
                    log.info("Delivered");
                    // Send a POST request to the "/reserve" endpoint with a status of "not
                    // reserved"
                }
            }
        });

        /*
         * if (status.equals("delivered")) {
         * // Do something with the delivered status here
         * log.info("delivered");
         * } else if (status.equals("cancelled")) {
         * // Do something with the cancelled status here
         * log.info("Cancelled");
         * } else {
         * // Handle invalid status here
         * }
         */
        return "redirect:/reservationlist";
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
