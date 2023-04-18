package k23op1.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import k23op1.backend.domain.Manufacturer;
import k23op1.backend.domain.ManufacturerRepository;
import k23op1.backend.domain.Product;
import k23op1.backend.domain.ProductRepository;

@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BackendApplication.class);
	}

	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {

		return (args) -> {
			Manufacturer manufacturer1 = new Manufacturer("Adidas");
			Manufacturer manufacturer2 = new Manufacturer("Puma");
			manufacturerRepository.save(manufacturer1);
			manufacturerRepository.save(manufacturer2);

			productRepository.save(new Product("Kiva", "shirt", "M", "blue", 15.15, manufacturer1));
			productRepository.save(new Product("Ok", "shirt", "M", "red", 10.10, manufacturer2));

			for (Product product : productRepository.findAll()) {
				log.info(product.toString());
			}
		};
	}

}
