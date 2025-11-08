package pj12_JVCollectionFramework.repository;

import pj12_JVCollectionFramework.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductManagerRepository {
    private static List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (Product p : products){
            if(Objects.equals(p.getId(), product.getId())){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
            }
        }
    }

    public void removeProduct(int id){
        for (Product p : products) {
            if(Objects.equals(p.getId(),id)){
                products.remove(p);
            }
        }
    }

    public boolean findById(int id){
        for (Product productManager : products){
            if (productManager.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Product findProductById(int id){
        for (Product productManager : products){
            if(productManager.getId() == id){
                return productManager;
            }
        }
        return null;
    }

    public Product findProductByName(String name){
        for (Product productManager : products){
            if(productManager.getName() == name){
                return productManager;
            }
        }
        return null;
    }

    public void sortProductByPrice(){
        Collections.sort(products, new SortProductByPrice());
    }
}
