package HeThongQuanLySinhVien.repository;

import HeThongQuanLySinhVien.entity.LopHoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepoLopHoc {
    public static final String FILE_HD = "HeThongQuanLySinhVien/data/batchs.csv";

    private List<LopHoc> listLopHoc;

    public RepoLopHoc() {
        listLopHoc = new ArrayList<>();
        try {
            loadFormFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<LopHoc> getListLopHoc() {
        return listLopHoc;
    }

    public String getTenLop(String malop) {
        for (LopHoc lopHoc : listLopHoc) {
            if (malop.equals(lopHoc.getMaLop())) {
                return lopHoc.getTenLop();
            }
        }
        return null;
    }

    private void loadFormFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_HD))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length < 3) continue;

                String maLop = data[0].trim();
                String tenLop = data[1].trim();
                int maGV = Integer.parseInt(data[2].trim());
                listLopHoc.add(new LopHoc(maLop, tenLop, maGV));

            }

        } catch (FileNotFoundException e) {
            throw new Exception("Lỗi ghi file!");
        }
    }
}
