package k23op1.backend.domain;

// Kommentoin noi importit väliaikasesti pois, kun vscode ilmoitti ettei niitä käytetä ja tuli rumia keltaisia merkintöjä :(
// import java.util.List;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 // import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {
    @Id // Primary key -määritys
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manufacturerid;
    private String name;

    // Category 1--* Product
    /*
     * @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
     * 
     * @JsonIgnoreProperties("manufacturer")
     * private List<Product> products;
     * 
     */

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

    @Override
    public String toString() {
        // tänne ei kirjan attribuutteja ikuisen luupin välttämiseksi tietokantahaussa!
        return "Manufacturer [manufacturerid=" + manufacturerid + ", name=" + name + "]";
    }

}
