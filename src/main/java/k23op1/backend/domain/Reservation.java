package k23op1.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;
    private String custName;
    private String email;
    private String phone;
    private String name;
    private String type;
    private String size;
    private String color;
    private double price;
    private String status;

    // Reservation 1--*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    @JsonIgnore
    private List<Product> products;

    public Reservation() {

    }

    public Reservation(String custName, String email,
            String phone, String name, String type, String size, String color,
            double price, String status) {
        super();
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.status = status;
        // this.manufacturer = manufacturer;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Reservation [id = " + reservationId + " customer name = " + custName + " email = " + email + " phone = "
                + phone + " name = " + name + " type = " + type + " size = " + size + " color = "
                + color
                + " price = " + price + " status = " + status
                + "]";
    }

    public static void updateReservationStatus(Long id, String status) {
    }

    public boolean isDelivered() {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }
}
