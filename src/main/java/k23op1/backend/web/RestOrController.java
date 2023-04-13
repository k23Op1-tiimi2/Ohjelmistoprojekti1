package k23op1.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@RestController
public class RestOrController {
    
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

     // REST-metodi, find all products where type=jacket/coat
   /*  @GetMapping(value = "/jackets")
    public @ResponseBody List<Product> findAllJackets() {
        return (List<Product>) productRepository.findByTypeIn(Arrays.asList("jacket", "coat"));
    } */

    // REST-metodi, find one type
    @GetMapping("/products/type/{type}")
    List<Product> getCarByBrand(@PathVariable String type) {
        
        return productRepository.findByType(type);
    }
}

