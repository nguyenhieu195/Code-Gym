package QLhoaDonTienDien.entity;

public class KhachHang {
    private Integer maKH;
    private String tenKH;

    public KhachHang(Integer maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
}
