package QLhoaDonTienDien.entity;

public class KHNuocNgoai extends KhachHang{

    private String quocTich;

    public KHNuocNgoai(Integer maKH, String hoTen, String quocTich) {
        super(maKH, hoTen);
        this.quocTich = quocTich;
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

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "KHNuocNgoai[" +
                "maKH=" + getMaKH() +
                ", hoTen='" + getHoTen() + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ']';
    }
}
