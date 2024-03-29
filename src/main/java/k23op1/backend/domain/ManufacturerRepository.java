package k23op1.backend.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    List<Manufacturer> findByName(String name);
   // Optional<Manufacturer> findById (Long manufacturerid);

}