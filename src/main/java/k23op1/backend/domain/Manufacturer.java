package k23op1.backend.domain;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Manufacturer {
    @Id // Primary key -määritys
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manufacturerid;
    @NotNull
    private String name;

    // Manufacturer 1--* Product

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")

    @JsonIgnoreProperties("manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(String name) {
        super();
        this.name = name;
    }

    public Long getManufacturerid() {
        return manufacturerid;
    }

    public void setManufacturerid(Long manufacturerid) {
        this.manufacturerid = manufacturerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        // tänne ei valmistajan attribuutteja ikuisen luupin välttämiseksi
        // tietokantahaussa!
        return "Manufacturer [manufacturerid=" + manufacturerid + ", name=" + name + "]";
    }

    public Optional<Product> findByName(String string) {
        return null;
    }

    public Long getId() {
        return manufacturerid;
    }

}
