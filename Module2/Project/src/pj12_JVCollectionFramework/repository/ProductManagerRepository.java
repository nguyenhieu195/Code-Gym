package pj12_JVCollectionFramework.repository;

import pj12_JVCollectionFramework.entity.Product;
import pj12_JVCollectionFramework.service.SortProductByID;
import pj12_JVCollectionFramework.service.SortProductByPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductManagerRepository {
    private final List<Product> products;

    public ProductManagerRepository() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(Product product) {
        for (Product p : products) {
            if (Objects.equals(p.getId(), product.getId())) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return true;
            }
        }
        return false;
    }

    public void removeProduct(int id) {
        products.removeIf(product -> Objects.equals(product.getId(), id));
    }

    public boolean checkIdProduct(int id) {
        for (Product productManager : products) {
            if (productManager.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Product findProductById(int id) {
        for (Product productManager : products) {
            if (productManager.getId() == id) {
                return productManager;
            }
        }
        return null;
    }

    public Product findProductByName(String name) {
        for (Product productManager : products) {
            if (Objects.equals(productManager.getName(), name)) {
                return productManager;
            }
        }
        return null;
    }

    public Product findByPrice(float price){
        for (Product product : products){
            if(Objects.equals(product.getPrice(), price)) return product;
        }
        return null;
    }
    public List<Product> findByPriceAToB(float a, float b){
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if(product.getPrice() >= a && product.getPrice() <= b){
                list.add(product);
            }
        }
        return list;
    }

    public void sortProductByPrice() {
        Collections.sort(products, new SortProductByPrice());
    }

    public void sortProductByID() {
        Collections.sort(products, new SortProductByID());
    }

    public List<Product> displayProducts() {
        return products;
    }

}
