package pj12_JVCollectionFramework.entity;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private static Integer nextID = 0;

    public Product(String name, Double price) {
        this.id = ++nextID;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
        this.id = nextID++;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ']';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
