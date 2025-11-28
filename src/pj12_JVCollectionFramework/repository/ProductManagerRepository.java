package pj12_JVCollectionFramework.repository;

import pj12_JVCollectionFramework.entity.Product;
import pj12_JVCollectionFramework.service.SortProductByID;
import pj12_JVCollectionFramework.service.SortProductByPrice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    public Product findByPrice(float price) {
        for (Product product : products) {
            if (Objects.equals(product.getPrice(), price)) return product;
        }
        return null;
    }

    public List<Product> findByPriceAToB(float a, float b) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= a && product.getPrice() <= b) {
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

    public boolean readFile(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] part = line.split(",");

                int id = Integer.parseInt(part[0].trim());
                String name = part[1].replace("\"", "").trim();
                Double price = Double.parseDouble(part[2].replace("\"", "").trim());

                Product product = new Product(id, name, price);
                products.add(product);
            }

            return true;
        } catch (Exception e) {
            System.out.println("Lỗi đọc file !");
        }
        return false;
    }

    public boolean copyFile(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Kiểm tra file nguồn
        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại!");
            return false;
        }

        // Kiểm tra file đích
        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại, không thể ghi đè!");
            return false;
        }

        int charCount = 0;

        try (
                FileReader reader = new FileReader(sourceFile);
                FileWriter writer = new FileWriter(targetFile)
        ) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
                charCount++;
            }

            System.out.println("Sao chép hoàn tất!");
            System.out.println("Số ký tự đã copy: " + charCount);
            return true;

        } catch (Exception e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
            return false;
        }
    }
}
