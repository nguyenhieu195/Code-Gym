package pj12_JVCollectionFramework.service;

import pj12_JVCollectionFramework.entity.Product;
import pj12_JVCollectionFramework.repository.ProductManagerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductManagerService implements IProductManagerService {
    private final ProductManagerRepository repository;

    public ProductManagerService() {
        repository = new ProductManagerRepository();
    }

    //    public boolean addProduct(Product product){
//        if (repository.checkIdProduct(product.getId())) {
//            return false;
//        }
//        repository.addProduct(product);
//        return true;
//    }
    public boolean addProduct(Product product) throws Exception {
        if (repository.findProductById(product.getId()) != null) {
            throw new Exception("ID đã tồn tại !");
        }
        repository.addProduct(product);
        return true;
    }

    public boolean removeProduct(int id) {
        if (repository.checkIdProduct(id)) {
            repository.removeProduct(id);
            return true;
        }
        return false;
    }

    public boolean updateProduct(Product product) {

        return repository.updateProduct(product);
    }

    public Product findProductById(int id) {

        return repository.findProductById(id);
    }

    public Product findProductByName(String name) {

        return repository.findProductByName(name);
    }

    public boolean sortProductByPrice() {
        List<Product> oldP = new ArrayList<>(repository.displayProducts());
        repository.sortProductByPrice();
        List<Product> newP = repository.displayProducts();
        return !Objects.equals(oldP, newP);
    }

    public boolean sortProductByID() {
        List<Product> oldP = new ArrayList<>(repository.displayProducts());
        repository.sortProductByID();
        List<Product> newP = repository.displayProducts();
        return !Objects.equals(oldP, newP);
    }

    public List<Product> displayProducts() {

        return repository.displayProducts();
    }

    public boolean checkByID(int id){
        return repository.checkIdProduct(id);
    }

    public boolean readFile(String file){
        return repository.readFile(file);
    }

    public boolean copyFile(String s, String t){
        return repository.copyFile(s, t);
    }
}
