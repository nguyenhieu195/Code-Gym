package pj17_file;




import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final String File_Path = "pj17_file/data.csv";

    public static void writetoFile(List<QuanLySanPham> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Path))) {
            oos.writeObject(products);
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi ghi file :" + e.getMessage());
        }
    }

    public static List<QuanLySanPham> readFromFile() {
        List<QuanLySanPham> products = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(File_Path))) {
            products = (List<QuanLySanPham>) ois.readObject();
        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return products;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<QuanLySanPham> list = readFromFile();
        while (true) {
            System.out.println();
            System.out.println("=======MENU=======");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi san pham");
            System.out.println("3. Tim kiem theo ma");
            System.out.println("4. Thoat");
            System.out.println();
            System.out.println("=======Lua chon=======");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    list.add(inputProduct(sc));
                    writetoFile(list);
                    break;
                case 2:
                    System.out.printf("%-5s %-10s %-10s %-15s %-15s%n", "id", "name", "price", "manufacturer", "note");
                    for (QuanLySanPham p : list) {
                        System.out.printf("%-5d %-10s %-10.2f %-15s %-15s%n",
                                p.getId(), p.getName(), p.getPrice(), p.getManufacturer(), p.getNote());
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma :");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean found = false;
                    for (QuanLySanPham p : list) {
                        if (p.getId() == id) {
                            System.out.println("Tim thay: " + p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 4:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Vui long nhap laij");
            }
        }
    }

    private static QuanLySanPham inputProduct(Scanner sc) {
        System.out.print("Ma San pham: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Ten san pham: ");
        String name = sc.nextLine();
        System.out.println("Gia: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Hang san xuat: ");
        String manu = sc.nextLine();
        System.out.println("Ghi chu: ");
        String note = sc.nextLine();
        return new QuanLySanPham(id, name, price, manu, note);
    }
}