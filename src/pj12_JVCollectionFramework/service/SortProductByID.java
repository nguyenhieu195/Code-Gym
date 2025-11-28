package pj12_JVCollectionFramework.service;

import pj12_JVCollectionFramework.entity.Product;

import java.util.Comparator;

public class SortProductByID implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
