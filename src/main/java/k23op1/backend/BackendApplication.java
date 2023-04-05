package k23op1.backend;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;


@SpringBootApplication
public class BackendApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("Kiva", "shirt", "M", "blue", 15));

			for (Product product : productRepository.findAll()) {
				log.info(product.toString());
			}
		};
	}

}
