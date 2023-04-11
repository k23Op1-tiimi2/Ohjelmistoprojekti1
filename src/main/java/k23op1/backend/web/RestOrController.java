package k23op1.backend.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@RestController
public class RestOrController {

    private static final Logger log = LoggerFactory.getLogger(RestController.class);
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;
    
     // REST-metodi, find all products
     @GetMapping(value = "/products")
     public @ResponseBody List<Product> findAllProducts() {
         return (List<Product>) productRepository.findAll();
     }
 
     // REST-metodi, find all manufacturers
     @GetMapping(value = "/manufacturers")
     public @ResponseBody List<Manufacturer> findAllManufaccturers() {
         return (List<Manufacturer>) manufacturerRepository.findAll();
     }
}
