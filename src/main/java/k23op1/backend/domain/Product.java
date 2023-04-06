package k23op1.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String size;
    private String color;
    private int price;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "manufacturerid") // Foreign key - määritys
    private Manufacturer manufacturer;

    public Product() {

    }

    public Product(Long id, String name, String type, String size, String color, int price, Manufacturer manufacturer) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        if (this.manufacturer != null)
            return "Product [id = " + id + " name = " + name + " type = " + type + " size = " + size + " color = "
                    + color
                    + " price = " + price + "manufacturer=" + manufacturer + "]";

        else
            return "Product [id = " + id + " name = " + name + " type = " + type + " size = " + size + " color = "
                    + color
                    + " price = " + price;

    }

}
