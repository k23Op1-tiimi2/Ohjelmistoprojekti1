package k23op1.backend.domain;

@Entity
public class Product {
    @Id // primary key
    @GeneratedValue(strategy = GenereationType.AUTO)
    private Long id;
    private String name;
    private String size;
    private String color;
    private int price;

    public Product() {
        super();
        this.id = null;
        this.name = null;
        this.size = null;
        this.color = null;
        this.price = 0;
    }

    public Product(String name, String size, String color, int price) {
        super();
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Product(Long id, String name, String size, String color, int price) {
        super();
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product id = " + id + " name = " + name + " size = " + size + " color = " + color
                + " price = " + price;
    }

    // todo toString2 valmistajan kanssa
}
