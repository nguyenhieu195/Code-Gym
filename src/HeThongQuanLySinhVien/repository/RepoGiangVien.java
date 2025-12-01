package HeThongQuanLySinhVien.repository;


import HeThongQuanLySinhVien.entity.GiangVien;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepoGiangVien {

    public static final String FILE_HD = "HeThongQuanLySinhVien/data/GiangVien.csv";
    private List<GiangVien> giangVienList;

    public RepoGiangVien() throws Exception {
        giangVienList = new ArrayList<>();
        loadFormFile();
    }

    public List<GiangVien> getGiangVienList() {
        return giangVienList;
    }

    private void loadFormFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_HD))) {

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 5) continue;

                int maGV = Integer.parseInt(data[0].trim());
                String hoTen = data[1].trim();
                String gioiTinh = data[2].trim();

                LocalDate ngaySinh = LocalDate.parse(
                        data[3].trim(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")
                );

                String sdt = data[4].trim();

                giangVienList.add(new GiangVien(maGV, hoTen, gioiTinh, ngaySinh, sdt));
            }

        } catch (FileNotFoundException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {
                bw.write("magv,hoTen,gioiTinh,ngaySinh,sdt");
                bw.newLine();
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_HD))) {

            bw.write("magv,hoTen,gioiTinh,ngaySinh,sdt");
            bw.newLine();

            for (GiangVien gv : giangVienList) {
                bw.write(gv.getMaGV() + ","
                        + gv.getHoTen() + ","
                        + gv.getGioiTinh() + ","
                        + gv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ","
                        + gv.getSoDT());
                bw.newLine();
            }

        } catch (IOException ioe) {
            throw new Exception("Lỗi ghi file!");
        }
    }
}