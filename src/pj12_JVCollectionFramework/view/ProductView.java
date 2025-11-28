package pj12_JVCollectionFramework.view;

import pj12_JVCollectionFramework.controller.ProductManagerController;
import pj12_JVCollectionFramework.entity.Product;

import java.util.Random;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private final ProductManagerController controller;

    public ProductView() {
        controller = new ProductManagerController();
    }

    public void menu() {
        while (true) {
            System.out.println("\n------------- Product Manager -------------");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product By ID");
            System.out.println("4. Find Product By ID");
            System.out.println("5. Find Product By Name");
            System.out.println("6. Sort List Product By Price");
            System.out.println("7. Sort List Product By ID");
            System.out.println("8. Display Product");
            System.out.println("9. Read information from file");
            System.out.println("10. Copy file");
            System.out.println("0. Exit");
            System.out.println("-------------------------------------------");

            int choice = -1;
            boolean valid = false;

            while (!valid) {
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 0 && choice <= 10) {
                        valid = true;
                    } else {
                        System.err.println("Please enter a number between 0 and 10!");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input! Please enter a number.");
                }
            }

            // 🔹 Thực hiện lựa chọn
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> removeProduct();
                case 4 -> findProductById();
                case 5 -> findProductByName();
                case 6 -> sortProductByPrice();
                case 7 -> sortProductByID();
                case 8 -> disPlay();
                case 9 -> readFile("product.csv");
                case 10 -> copyFileMenu();
                case 0 -> {
                    System.out.println("Exit program...");
                    return; // thoát vòng lặp menu
                }
                default -> System.out.println("Invalid choice!"); // (dự phòng)
            }
        }
    }

    private void addProduct() {
        System.out.println("---- Add new product ----");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name product: ");
        String name = scanner.nextLine();
        System.out.print("Enter price product: ");
        double price = Double.parseDouble(scanner.nextLine());

        try{
            Product product = new Product(id, name, price);
            controller.addProduct(product);
            System.out.println("Add success!");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void updateProduct() {
        System.out.println("---- Update product ----");
        System.out.print("Enter product ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product oldProduct = controller.findProductById(id);

        if (oldProduct == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new name (leave empty to keep old): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = oldProduct.getName();

        System.out.print("Enter new price (or -1 to keep old): ");
        double price = Double.parseDouble(scanner.nextLine());
        if (price < 0) price = oldProduct.getPrice();

        Product updated = new Product(id, name, price);
        if (controller.updateProduct(updated)) {
            System.out.println("Update success!");
        } else {
            System.out.println("Update failed!");
        }
    }

    private void removeProduct() {
        System.out.println("---- Remove product ----");
        System.out.print("Enter product ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.removeProduct(id)) {
            System.out.println("Remove success!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private void findProductById() {
        System.out.println("---- Find product by ID ----");
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = controller.findProductById(id);
        if (product != null) {
            System.out.println("Found: " + product);
        } else {
            System.out.println("Product not found!");
        }
    }

    private void findProductByName() {
        System.out.println("---- Find product by Name ----");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        Product product = controller.findProductByName(name);
        if (product != null) {
            System.out.println("Found: " + product);
        } else {
            System.out.println("Product not found!");
        }
    }

    private void sortProductByPrice() {
        System.out.println("---- Sort products by price ----");
        if (controller.sortProductByPrice()) {
            System.out.println("Sorted successfully!");
        } else {
            System.out.println("Sort failed!");
        }
    }

    private void sortProductByID() {
        System.out.println("---- Sort products by id ----");
        if (controller.sortProductByID()) {
            System.out.println("Sorted successfully!");
        } else {
            System.out.println("Sort failed!");
        }
    }

    private void disPlay() {
        System.out.println("---- List All Product ----");
        controller.displayProducts().forEach(System.out::println);
    }

    private void readFile(String file){
        System.out.println("Bạn muốn đọc file?");
        if(controller.readFile(file)){
            System.out.println("Đọc file thanh công .");
        }else{
            System.out.println("Chịuuuuuuu!");
        }
    }

    private void copyFileMenu(){
        System.out.println("Nhập file nguồn: ");
        String source = scanner.nextLine();

        System.out.println("Nhập file đích: ");
        String target = scanner.nextLine();

        if(controller.copyFile(source, target)){
            System.out.println("Copy thành công!");
        } else {
            System.out.println("Copy thất bại!");
        }
    }
}
