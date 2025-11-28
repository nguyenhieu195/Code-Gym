package pj12_JVCollectionFramework.service;

import pj12_JVCollectionFramework.entity.Product;

public interface IProductManagerService {
    public boolean addProduct(Product product) throws Exception;

    public boolean removeProduct(int id);

    public boolean updateProduct(Product product);

    public Product findProductById(int id);

    public Product findProductByName(String name);

    public boolean sortProductByPrice();
}
