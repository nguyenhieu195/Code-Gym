package QLhoaDonTienDien.repository;

import QLhoaDonTienDien.entity.HoaDon;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepoHoaDon {
    public static final String FILE_HD = "QLhoaDonTienDien/data/hoadon.csv";
    private List<HoaDon> listHoaDon;

    public RepoHoaDon() {
        listHoaDon = new ArrayList<>();

        try {
            loadFormFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public HoaDon getHoaDon(int maHD) {
        for (HoaDon hd : listHoaDon) {
            if (hd.getMaHD() == maHD) {
                return hd;
            }
        }
        return null;
    }

    public void themHoaDon(HoaDon hoaDon) throws Exception {
        listHoaDon.add(hoaDon);
        saveToFile();
    }

    public void xoaHoaDon(int mahd) throws Exception {
        if (getHoaDon(mahd) == null) {
            return;
        }
        listHoaDon.removeIf(hd -> hd.getMaHD() == mahd);
        saveToFile();
    }

    public boolean suaHoaDon(HoaDon hoaDon) throws Exception {
        if (getHoaDon(hoaDon.getMaHD()) == null) {
            return false;
        }
        for (HoaDon hd : listHoaDon) {
            if (hd.getMaHD() == hoaDon.getMaHD()) {
                hd.setNgayRaHoaDon(hoaDon.getNgayRaHoaDon());
                hd.setDonGia(hoaDon.getDonGia());
                hd.setThanhTien(hoaDon.getThanhTien());
                saveToFile();
                return true;
            }
        }
        return false;
    }

    private void loadFormFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_HD))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                    // bỏ qua dòng đầu tiền là dòng tiêu đề
                }

                String[] data = line.split(",");
                if (data.length < 6) {
                    continue;
                    // nếu không đủ 6 cột thì bỏ qua dòng này
                }

                int maHD = Integer.parseInt(data[0].trim());
                int maKH = Integer.parseInt(data[1].trim());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate ngayRaHoaDon = LocalDate.parse(data[2].trim(), dtf);
                float soLuongTieuThu = Float.parseFloat(data[3].trim());
                float donGia = Float.parseFloat(data[4].trim());
                double thanhTien = Float.parseFloat(data[5].trim());

                listHoaDon.add(new HoaDon(maHD,maKH, ngayRaHoaDon, soLuongTieuThu, donGia, thanhTien));
            }
        } catch (Exception e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {
                bw.write("mahd,makh,ngày ra hoá đơn,số lượng tiêu thụ, đơn giá, thành tiền");
                bw.newLine();
            } catch (IOException ioe) {
                throw new Exception("Lỗi ghi file!");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {
            bw.write("mahd,makh,ngày ra hoá đơn,số lượng tiêu thụ, đơn giá, thành tiền");
            bw.newLine();

            for (HoaDon hoaDon : listHoaDon) {
                bw.write(hoaDon.getMaHD() + "," + hoaDon.getMaKH() + "," + hoaDon.getNgayRaHoaDon().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "," + hoaDon.getSoLuongTieuThu() + "," + hoaDon.getDonGia() + "," + hoaDon.getThanhTien());
                bw.newLine();
            }
        } catch (IOException ioe) {
            throw new Exception("Lỗi ghi file!");
        }
    }

}
