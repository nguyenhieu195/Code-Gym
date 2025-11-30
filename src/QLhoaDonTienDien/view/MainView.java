package QLhoaDonTienDien.view;

import QLhoaDonTienDien.common.CheckInput;
import QLhoaDonTienDien.entity.HoaDon;
import QLhoaDonTienDien.entity.KHNuocNgoai;
import QLhoaDonTienDien.entity.KHVietNam;
import QLhoaDonTienDien.entity.KhachHang;
import QLhoaDonTienDien.repository.RepoHoaDon;
import QLhoaDonTienDien.repository.RepoKhachHang;

import java.time.LocalDate;

public class MainView {
    private RepoHoaDon repoHoaDon;
    private RepoKhachHang repoKhachHang;
    private CheckInput input;

    public MainView() {
        repoHoaDon = new RepoHoaDon();
        repoKhachHang = new RepoKhachHang();
        input = new CheckInput();
    }

    public void menu() {
        CheckInput input = new CheckInput();
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ HOÁ ĐƠN TIỀN ĐIỆN");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Hiển thị thông tin khách hàng");
            System.out.println("3. Tìm kiếm khách hàng");
            System.out.println("4. Thêm mới hoá đơn");
            System.out.println("5. Chỉnh sửa hoá đơn");
            System.out.println("6. Hiển thị thông tin chi tiết hoá đơn");
            System.out.println("7. Thoát");

            int choice = input.inputInt("Nhập lựa chọn: ");

            switch (choice) {
                case 1 -> themKhachHang();
                case 2 -> HienThiThongTinKH();
                case 3 -> TimKiemKH();
                case 4 -> ThemMoiHoaDon();
                case 5 -> ChinhSuaHoaDon();
                case 6 -> ChiTietHoaDon();
                case 7 -> {
                    System.exit(0);
                }
            }

        }
    }

    private void themKhachHang() {
        System.out.println("----- THÊM KHÁCH HÀNG MỚI -----");
        final String KHNuocNgoai = "Nước Ngoài";
        final String KHVietNam = "Việt Nam";
        String KhachHang;
        do {
            KhachHang = input.inputString("Nhập loại khách hàng(Việt Nam / Nước Ngoài): ");
        } while (!KhachHang.equals(KHNuocNgoai) && !KhachHang.equals(KHVietNam));

        int makh = input.inputInt("Nhập mã Khách hàng: ");
        String hoten = input.inputString("Nhập họ tên: ");

        if (KhachHang.equals(KHNuocNgoai)) {
            String quocTich = input.inputString("Nhập quốc tịch: ");
            KHNuocNgoai khNuocNgoai = new KHNuocNgoai(makh, hoten, quocTich);
            try {
                repoKhachHang.add(khNuocNgoai);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            String loaiKhachHang = input.inputString("Nhập loại khách hàng (Sinh hoạt / Kinh doanh / Sản xuất): ");
            float dinhMucTieuThu = input.inputPositiveFloat("Nhập định mức tiêu thụ: ");
            KHVietNam khVietNam = new KHVietNam(makh, hoten, loaiKhachHang, dinhMucTieuThu);
            try {
                repoKhachHang.add(khVietNam);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void HienThiThongTinKH() {
        System.out.println("----- HIỂN THỊ THÔNG TIN KHÁCH HÀNG -----");
        for (KhachHang khachHang : repoKhachHang.getList()) {
            System.out.println(khachHang.toString());
        }
    }

    private void TimKiemKH() {
        System.out.println("----- TÌM KHÁCH HÀNG -----");
        String hoTen = input.inputString("Nhập tên khách hàng: ");

        for (KhachHang khachHang : repoKhachHang.getList()) {
            if (khachHang.getTenKH().toLowerCase().contains(hoTen.toLowerCase())) {
                System.out.println(khachHang.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
        System.out.println();
    }

    private void ThemMoiHoaDon() {
        System.out.println("----- THÊM HOÁ ĐƠN -----");
        HienThiThongTinKH();
        int maKH = input.inputPositiveInt("Nhập mã khách hàng để thêm hoá đơn: ");
        KhachHang khachHang = repoKhachHang.getById(maKH);
        if (khachHang == null) {
            return;
        }
        LocalDate ngayRaHoaDon = input.getDate("Nhập ngày ra hoá đơn: ");
        float soluongTieuThu = input.inputPositiveFloat("Nhập số lượng tiêu thụ (KW): ");
        float donGia = input.inputPositiveFloat("Nhập đơn giá: ");
        double thanhTien = 0;
        if (khachHang instanceof KHVietNam) {
            float dinhMuc = ((KHVietNam) khachHang).getDinhMuc();
            if (dinhMuc >= soluongTieuThu) {
                thanhTien = soluongTieuThu * donGia;
            } else {
                thanhTien = soluongTieuThu * donGia * dinhMuc + (soluongTieuThu - dinhMuc) * donGia * 2.5;
            }
        } else {
            thanhTien = soluongTieuThu * donGia;
        }
        try {
            repoHoaDon.themHoaDon(new HoaDon(maKH, ngayRaHoaDon, soluongTieuThu, donGia, thanhTien));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ChinhSuaHoaDon() {
        System.out.println("----- SỬA HOÁ ĐƠN -----");
        HienThiThongTinKH();
        int maKH = input.inputPositiveInt("Nhập mã khách hàng để  hoá đơn: ");
        KhachHang khachHang = repoKhachHang.getById(maKH);
        if (khachHang == null) {
            return;
        }
        LocalDate ngayRaHoaDon = input.getDate("Nhập ngày ra hoá đơn: ");
        float soluongTieuThu = input.inputPositiveFloat("Nhập số lượng tiêu thụ (KW): ");
        float donGia = input.inputPositiveFloat("Nhập đơn giá: ");
        double thanhTien = 0;
        if (khachHang instanceof KHVietNam) {
            float dinhMuc = ((KHVietNam) khachHang).getDinhMuc();
            if (dinhMuc >= soluongTieuThu) {
                thanhTien = soluongTieuThu * donGia;
            } else {
                thanhTien = soluongTieuThu * donGia * dinhMuc + (soluongTieuThu - dinhMuc) * donGia * 2.5;
            }
        } else {
            thanhTien = soluongTieuThu * donGia;
        }
        try {
            repoHoaDon.themHoaDon(new HoaDon(maKH, ngayRaHoaDon, soluongTieuThu, donGia, thanhTien));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ChiTietHoaDon() {
    }

}
