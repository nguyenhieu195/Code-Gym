package pj17_file;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final String File_Path = "pj17_file/data.dat"; // đổi CSV thành DAT

    public static void writeToFile(List<QuanLySanPham> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Path))) {
            oos.writeObject(products);
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public static List<QuanLySanPham> readFromFile() {
        List<QuanLySanPham> products = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(File_Path))) {
            products = (List<QuanLySanPham>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Chưa có file, tạo danh sách mới!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return products;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<QuanLySanPham> list = readFromFile();

        while (true) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm theo mã");
            System.out.println("4. Thoát");
            System.out.println("====================");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {

                case 1:
                    list.add(inputProduct(sc));
                    writeToFile(list);
                    break;

                case 2:
                    System.out.printf("%-5s %-10s %-10s %-15s %-15s%n",
                            "ID", "Name", "Price", "Manufacturer", "Note");

                    for (QuanLySanPham p : list) {
                        System.out.printf("%-5d %-10s %-10.2f %-15s %-15s%n",
                                p.getId(), p.getName(), p.getPrice(),
                                p.getManufacturer(), p.getNote());
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã: ");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean found = false;

                    for (QuanLySanPham p : list) {
                        if (p.getId() == id) {
                            System.out.println("Tìm thấy: " + p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static QuanLySanPham inputProduct(Scanner sc) {
        System.out.print("Mã sản phẩm: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Hãng sản xuất: ");
        String manu = sc.nextLine();

        System.out.print("Ghi chú: ");
        String note = sc.nextLine();

        return new QuanLySanPham(id, name, price, manu, note);
    }
}