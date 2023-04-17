import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.backend.BackendApplication;
import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@SpringBootTest(classes = BackendApplication.class)
public class ProductRepositoryTest {
    

@Autowired
private ProductRepository productRepository;



@Autowired
private ManufacturerRepository manufacturerRepository;



@Test // testataan ProductRepositoryn save()-metodin toimivuutta
public void createNewProduct() {
    
    
   Manufacturer manufacturer1= new Manufacturer("Dog clothes oy");
   manufacturerRepository.save(manufacturer1);
    
   Product product1 = new Product("Jotain", "Valjaat", "M", "Yellow", 13.0, manufacturer1);
   
    //Book book = new Book(1, "Idiootti", "Fjodor Dostojevski", 1868 , "978-951-1-26266-4", 9.90, null);
    

    
    
    
    productRepository.save(product1);
    assertThat(product1.getId()).isNotNull();
}



@Test
public void deleteNewProduct () {

    Manufacturer manufacturer1= new Manufacturer("Dog clothes oy");
    manufacturerRepository.save(manufacturer1);
     
    Product product1 = new Product("Jotain", "Valjaat", "M", "Yellow", 13.0, manufacturer1);
    
    productRepository.save(product1);

    productRepository.delete(product1);

   assertThat(productRepository.findById(product1.getId()).isEmpty());


}



@Test
public void searchByName (){
    Manufacturer manufacturer1= new Manufacturer("Dog clothes oy");
    manufacturerRepository.save(manufacturer1);
     
    Product product1 = new Product("Jotain", "Valjaat", "M", "Yellow", 13.0, manufacturer1);
    
    productRepository.save(product1);

    // first product


    Manufacturer manufacturer2= new Manufacturer("Clothes");
    manufacturerRepository.save(manufacturer2);
     
    Product product2 = new Product("Tuote", "Hihna", "M", "Blue", 13.0, manufacturer2);
    
    productRepository.save(product2);
   
    // second product


List <Product> results = productRepository.findByNameContainingIgnoreCase("tuote");

assertThat(results).hasSize(1);



}









}


