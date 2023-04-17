package k23op1.backend;

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

@SpringBootTest(classes = BackendApplication.class)
public class ManufacturerRepositoryTest {
    


    @Autowired
    private ManufacturerRepository manufacturerRepository;



    @Test
    public void createNewProduct() {
       Manufacturer manufacturer1= new Manufacturer("Dog clothes oy");
       manufacturerRepository.save(manufacturer1);
    
       // Check that the id field of the saved manufacturer is not null
       Manufacturer savedManufacturer = manufacturerRepository.findById(manufacturer1.getId()).orElse(null);
       assertThat(savedManufacturer).isNotNull();
    
       assertThat(savedManufacturer.getId()).isNotNull();
    }


   
    






}
