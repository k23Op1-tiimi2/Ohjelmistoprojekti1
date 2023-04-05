package k23op1.backend.domain;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findById(Long productId);
}
