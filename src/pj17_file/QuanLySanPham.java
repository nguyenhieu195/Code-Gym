package pj17_file;


import java.io.Serializable;

public class QuanLySanPham implements Serializable {
    private int id;
    private String name;
    private double price;
    private String manufacturer;
    private String note;
    public QuanLySanPham(int id, String name, double price, String manufacturer,String note){
        this.id=id;
        this.name=name;
        this.price=price;
        this.manufacturer=manufacturer;
        this.note=note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price + "\t" + manufacturer + "\t" + note;
    }
}