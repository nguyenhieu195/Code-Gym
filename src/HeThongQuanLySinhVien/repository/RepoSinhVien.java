package HeThongQuanLySinhVien.repository;

import HeThongQuanLySinhVien.entity.SinhVien;
import QLhoaDonTienDien.entity.HoaDon;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepoSinhVien {

    public static final String FILE_HD = "HeThongQuanLySinhVien/data/SinhVien.csv";

    private List<SinhVien> listSinhVien;

    public RepoSinhVien() throws Exception {
        listSinhVien = new ArrayList<>();
        loadFormFile();
    }

    public List<SinhVien> getListSinhVien() {
        return listSinhVien;
    }

    public SinhVien findByName(String hoTen) {
        for (SinhVien sv : listSinhVien) {
            if (hoTen.equals(sv.getHoTen())) {
                return sv;
            }
        }
        return null;
    }
    public SinhVien findByID(Integer ID) {
        for (SinhVien sv : listSinhVien) {
            if (ID == sv.getMaSV()) {
                return sv;
            }
        }
        return null;
    }
    public void addSinhVien(SinhVien sinhVien) throws Exception {
        listSinhVien.add(sinhVien);
        saveToFile();
    }

    public void xoaSinhVien(int maSV) throws Exception {
        if (findByID(maSV) == null) {
            return;
        }
        listSinhVien.removeIf(hd -> hd.getMaSV() == maSV);
        saveToFile();
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

                int maSV = Integer.parseInt(data[0].trim());
                String hoTen = data[1].trim();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate ngaySinh = LocalDate.parse(data[3].trim(), dtf);
                String gioiTinh = data[2].trim();
                String sdt = data[4].trim();
                String maLop = data[5].trim();
                listSinhVien.add(new SinhVien(maSV, hoTen, gioiTinh, ngaySinh, sdt, maLop));
            }
        } catch (Exception e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {
                bw.write("masv,hoTen,gioiTinh,ngaySinh,sdt,maLop");
                bw.newLine();
            } catch (IOException ioe) {
                throw new Exception("Lỗi ghi file!");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {
            bw.write("masv,hoTen,gioiTinh,ngaySinh,sdt,maLop");
            bw.newLine();

            for (SinhVien sv : listSinhVien) {
                bw.write(sv.getMaSV() + "," + sv.getHoTen() + "," + sv.getGioiTinh() + "," + sv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "," + sv.getSoDT() + "," + sv.getMaLop());
                bw.newLine();
            }
        } catch (IOException ioe) {
            throw new Exception("Lỗi ghi file!");
        }
    }
}
