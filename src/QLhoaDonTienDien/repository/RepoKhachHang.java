package QLhoaDonTienDien.repository;

import QLhoaDonTienDien.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepoKhachHang {

    private static final String FILE = "QLhoaDonTienDien/data/khachhang.csv";

    private List<KhachHang> list;

    public RepoKhachHang() {
        list = new ArrayList<>();
        try {
            loadFile();
        } catch (Exception e) {
            System.out.println("Lỗi load file: " + e.getMessage());
        }
    }

    public List<KhachHang> getList() {
        return list;
    }

    public KhachHang getById(int maKH) {
        for (KhachHang kh : list) {
            if (kh.getMaKH() == maKH) {
                return kh;
            }
        }
        return null;
    }

    public void add(KhachHang kh) throws Exception {
        list.add(kh);
        saveToFile();
    }

    public void loadFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");
                if (d.length < 3) continue;

                int maKH = Integer.parseInt(d[0].trim());
                String tenKH = d[1].trim();
                String loai = d[2].trim(); // VN or NN

                // Nếu là khách hàng Việt Nam
                if (loai.equals("VN") && d.length >= 5) {
                    String loaiKH = d[3].trim();
                    float dinhMuc = Float.parseFloat(d[4].trim());
                    list.add(new KHVietNam(maKH, tenKH, loaiKH, dinhMuc));
                }

                // Nếu là khách hàng nước ngoài
                else if (loai.equals("NN") && d.length >= 4) {
                    String quocTich = d[3].trim();
                    list.add(new KHNuocNgoai(maKH, tenKH, quocTich));
                }
            }

        } catch (Exception e) {
            throw new Exception("Lỗi đọc file!");
        }
    }


    public void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (KhachHang kh : list) {
                bw.write(toStringFile(kh));
                bw.newLine();
            }

        } catch (Exception e) {
            throw new Exception("Lỗi ghi file!");
        }
    }

    private String toStringFile(KhachHang kh) {

        if (kh instanceof KHVietNam vn) {
            return vn.getMaKH() + "," +
                    vn.getTenKH() + ",VN," +
                    vn.getLoaiKhachHang() + "," +
                    vn.getDinhMuc();
        }
        else if (kh instanceof KHNuocNgoai nn) {
            return nn.getMaKH() + "," +
                    nn.getTenKH() + ",NN," +
                    nn.getQuocTich();
        }

        return "";
    }
}