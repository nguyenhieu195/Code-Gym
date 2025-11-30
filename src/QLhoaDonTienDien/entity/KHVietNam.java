package QLhoaDonTienDien.entity;

public class KHVietNam extends KhachHang {
    private String loaiKhachHang; // sinh hoat, kinh doanh, san xuat
    private Float dinhMuc; // định mức tiêu thụ

    public KHVietNam(Integer maKH, String hoTen, String loaiKhachHang, Float dinhMuc) {
        super(maKH, hoTen);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMuc = dinhMuc;
    }

    public Integer getMaKH() {
        return super.getMaKH();
    }

    public void setMaKH(Integer maKH) {
        super.setMaKH(maKH);
    }

    public String getHoTen() {
        return super.getTenKH();
    }

    public void setHoTen(String hoTen) {
        super.setTenKH(hoTen);
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public Float getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(Float dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    @Override
    public String toString() {
        return "KHVietNam[" +
                "maKH=" + getMaKH() +
                ", hoTen='" + getHoTen() + '\'' +
                ", loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMuc=" + dinhMuc +
                ']';
    }
}
