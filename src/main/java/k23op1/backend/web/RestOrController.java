package k23op1.backend.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;
import k23op1.backend.domain.Reservation;
import k23op1.backend.domain.ReservationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestOrController {

    private static final Logger log = LoggerFactory.getLogger(RestOrController.class);
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    ReservationRepository reservationRepository;
    
     // REST-metodi, find all products
     @GetMapping(value = "/products")
     public @ResponseBody List<Product> findAllProducts() {

        log.info("find all products");

         return (List<Product>) productRepository.findAll();
     }
 
     // REST-metodi, find all manufacturers
     @GetMapping(value = "/manufacturers")
     public @ResponseBody List<Manufacturer> findAllManufacturers() {

        log.info("find all manufacturers");

         return (List<Manufacturer>) manufacturerRepository.findAll();
     }

     // REST-metodi, find the products of one manufacturer
     @GetMapping("/manufacturers/id/{id}")
        Optional<Manufacturer> getOneManufacturer(@PathVariable Long id) {

        log.info("find the products of one manufacturer, id= " + id);

        return manufacturerRepository.findById(id);
     }

     // REST-metodi, add new product
    @PostMapping("products")
    Product newProduct(@RequestBody Product newProduct) {
        log.info("save new product " + newProduct);
        return productRepository.save(newProduct);
    }

    // REST-metodi, edit existing product
    @PutMapping("/products/{id}")
    Product editProduct(@RequestBody Product editedProduct, @PathVariable Long id) {
        log.info("edit product " + editedProduct);
        editedProduct.setId(id);
        return productRepository.save(editedProduct);
    }

    // REST-metodi, delete product
    @DeleteMapping("/products/{id}")
    public Iterable<Product> deleteProduct(@PathVariable Long id) {
        log.info("delete product, id = " + id);
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

     // REST-metodi, find one product and return it
    @GetMapping("/products/id/{id}")
    Optional<Product> getOneProduct(@PathVariable Long id) {

        log.info("find product, id = " + id);

        return productRepository.findById(id);
    }

    // REST-metodi, find one type
    @GetMapping("/products/type/{type}")
    List<Product> getProductByType(@PathVariable String type) {

        log.info("find product, type = " + type);
        
        return productRepository.findByType(type);
    }

     // REST-metodi, find all reservations
     @GetMapping(value = "/reservations")
     public @ResponseBody List<Reservation> findAllReservations() {

        log.info("find all reservations");

         return (List<Reservation>) reservationRepository.findAll();
     }

     // REST-metodi, add new reservation
    @PostMapping("reservations")
    Reservation newReservation(@RequestBody Reservation newReservation) {
        log.info("save new reservation " + newReservation);
        return reservationRepository.save(newReservation);
    }

    // REST-metodi, edit existing reservation
    @PutMapping("/reservations/{id}")
    Reservation editReservation(@RequestBody Reservation editedReservation, @PathVariable Long id) {
        log.info("edit reservation " + editedReservation);
        editedReservation.setReservationId(id);
        return reservationRepository.save(editedReservation);
    }

    // REST-metodi, delete reservation
    @DeleteMapping("/reservations/{id}")
    public Iterable<Reservation> deleteReservation(@PathVariable Long id) {
        log.info("delete reservation, id = " + id);
        reservationRepository.deleteById(id);
        return reservationRepository.findAll();
    }

    // REST-metodi, find one reservation and return it
    @GetMapping("/reservations/id/{id}")
    Optional<Reservation> getOneReservation(@PathVariable Long id) {

        log.info("find reservation, id = " + id);

        return reservationRepository.findById(id);
    }
}

