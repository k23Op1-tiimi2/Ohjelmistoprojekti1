package k23op1.backend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // perii kaikki findAll(), findById(), save(), deleteById() jne
    List<Product> findById(String productId);
}
