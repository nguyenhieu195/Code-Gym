package HeThongQuanLySinhVien.view;

import HeThongQuanLySinhVien.entity.GiangVien;
import HeThongQuanLySinhVien.entity.SinhVien;
import HeThongQuanLySinhVien.repository.RepoGiangVien;
import HeThongQuanLySinhVien.repository.RepoLopHoc;
import HeThongQuanLySinhVien.repository.RepoSinhVien;
import QLhoaDonTienDien.common.CheckInput;
import QLhoaDonTienDien.entity.HoaDon;
import QLhoaDonTienDien.entity.KHNuocNgoai;
import QLhoaDonTienDien.entity.KHVietNam;
import QLhoaDonTienDien.entity.KhachHang;
import QLhoaDonTienDien.repository.RepoHoaDon;
import QLhoaDonTienDien.repository.RepoKhachHang;

import java.time.LocalDate;
import java.util.List;

public class MainView {
    private RepoSinhVien repoSinhVien;
    private RepoLopHoc repoLopHoc;
    private RepoGiangVien repoGiangVien;
    private CheckInput input;

    public MainView() {
        try {
            repoGiangVien = new RepoGiangVien();
            repoLopHoc = new RepoLopHoc();
            repoSinhVien = new RepoSinhVien();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        input = new CheckInput();
    }

    public void menu() {
        CheckInput input = new CheckInput();
        while (true) {
            System.out.println("HỆ THỐNG QUẢN LÝ SINH VIÊN");
            System.out.println("1. Thêm mới Sinh viên");
            System.out.println("2. Xoá Sinh viên");
            System.out.println("3. Xem danh sách Sinh viên");
            System.out.println("4. Xem thông xin Giáo viên");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("0. Thoát");

            int choice = input.inputInt("Nhập lựa chọn: ");

            switch (choice) {
                case 1 -> themSV();
                case 2 -> xoaSinhVien();
                case 3 -> xemDSsinhVien();
                case 4 -> xemTTgiaoVien();
                case 5 -> timKiemSinhVien();
                case 0 -> {
                    System.exit(0);
                }
            }

        }
    }

    private void xoaSinhVien() {
        System.out.println("----- XOÁ SINH VIÊN -----");

        int masv = input.inputPositiveInt("Nhap ma sinh vien muon xoa: ");
        SinhVien sinhVien = repoSinhVien.findByID(masv);
        if (sinhVien == null) {
            System.out.println("Sinh vien khong ton tai");
        }
        String choice;
        do {
            choice = input.inputString("Ban co muon xoa khong(yes/no)");
        } while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));

        if (choice.equalsIgnoreCase("yes")) {
            try {
                repoSinhVien.xoaSinhVien(sinhVien.getMaSV());
                System.out.println("Xoa sinh vien thanh cong");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Xoa sinh vien that bai1");
            }
        } else {
            System.out.println("Da huy xoa sinh vien!");
        }
    }

    private void themSV() {
        System.out.println("----- THÊM SINH VIÊN MỚI -----");

        String nameRegex = "^[a-zA-Z]{4,50}$";
        String hoten = input.inputString("Nhập họ tên: ");
        while (!hoten.matches(nameRegex)) {
            System.out.println("Họ tên chưa hợp lệ !");
            hoten = input.inputString("Nhap lai: ");
        }
        String gioiTinh = input.inputString("Nhập giới tính: ");

        LocalDate ngaySinh = input.getDate("Nhập ngày sinh: ");

        String regexSTD = "^(091|090)[0-9]{7}$";
        String SDT = input.inputString("Nhap so dien thoai: ");
        while (!SDT.matches(regexSTD)) {
            System.out.println("Số điện thoại chưa hợp lệ !");
            SDT = input.inputString("Nhap lai: ");
        }

        String maLop = input.inputString("Nhập mã lớp: ");

        try {
            repoSinhVien.addSinhVien(new SinhVien(hoten, gioiTinh, ngaySinh, SDT, maLop));
            System.out.println("Them sinh vien thanh công");
        } catch (Exception e) {
            System.out.println("Them sinh vien that bai!");
        }
    }

    private void xemDSsinhVien() {
        System.out.println("----- XEM DANH SACH SINH VIEN -----");
        for (SinhVien sinhVien : repoSinhVien.getListSinhVien()) {

            System.out.println("MaSV: " + sinhVien.getMaSV());
            System.out.println("Ho ten: " + sinhVien.getHoTen());
            System.out.println("Ngay sinh: " + sinhVien.getNgaySinh());
            System.out.println("Gioi tinh: " + sinhVien.getGioiTinh());
            System.out.println("Ten lop: " + repoLopHoc.getTenLop(sinhVien.getMaLop()));
        }
    }

    private void xemTTgiaoVien() {
        System.out.println("----- XEM TT GIAO VIEN -----");
        for (GiangVien giangVien : repoGiangVien.getGiangVienList()) {
            System.out.println("MaGV: " + giangVien.getMaGV());
            System.out.println("Ho ten: " + giangVien.getHoTen());
            System.out.println("Ngay sinh: " + giangVien.getNgaySinh());
            System.out.println("Gioi tinh: " + giangVien.getGioiTinh());
            System.out.println("SDT: " + giangVien.getSoDT());
        }
    }

    // tìm kiếm gần đúng
    private void timKiemSinhVien() {
        System.out.println("----- TIM KIEM SINH VIEN -----");
        String name = input.inputString("Nhap ten sinh vien can tim: ").toLowerCase();

        boolean check = false;
        for (SinhVien sinhVien1 : repoSinhVien.getListSinhVien()) {
            if (sinhVien1.getHoTen().toLowerCase().contains(name)) {
                System.out.println(sinhVien1.toString());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay sinh vien");
        }
    }
}
