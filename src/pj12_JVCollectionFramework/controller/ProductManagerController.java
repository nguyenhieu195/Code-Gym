package pj12_JVCollectionFramework.controller;

import pj12_JVCollectionFramework.entity.Product;
import pj12_JVCollectionFramework.service.ProductManagerService;

import java.util.List;

public class ProductManagerController {
    private final ProductManagerService service;

    public ProductManagerController() {
        service = new ProductManagerService();
    }

    public boolean addProduct(Product product) throws Exception {
        return service.addProduct(product);
    }

    public boolean removeProduct(int id) {
        return service.removeProduct(id);
    }

    public boolean updateProduct(Product product) {
        return service.updateProduct(product);
    }

    public Product findProductById(int id) {
        return service.findProductById(id);
    }

    public Product findProductByName(String name) {
        return service.findProductByName(name);
    }

    public boolean sortProductByPrice() {
        return service.sortProductByPrice();
    }

    public boolean sortProductByID() {
        return service.sortProductByID();
    }

    public List<Product> displayProducts() {
        return service.displayProducts();
    }

    public boolean checkById(int id) {
        return service.checkByID(id);
    }

    public boolean readFile(String file) {
        return service.readFile(file);
    }

    public boolean copyFile(String s, String t){
        return service.copyFile(s, t);
    }
}
