package QLhoaDonTienDien.entity;

import java.time.LocalDate;
import java.util.Date;

public class HoaDon {

    private Integer maHD;
    private static Integer nextMaHD = 0;
    private Integer maKH;
    private LocalDate ngayRaHoaDon;
    private Float soLuongTieuThu; // số KW tiêu thụ
    private Float donGia;
    private Double thanhTien;

    public HoaDon(Integer maHD, Integer maKH, LocalDate ngayRaHoaDon, Float soLuongTieuThu, Float donGia, Double thanhTien) {

        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuongTieuThu = soLuongTieuThu;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        if(maHD > nextMaHD){
            nextMaHD = maHD;
        }
    }
    public HoaDon( Integer maKH, LocalDate ngayRaHoaDon, Float soLuongTieuThu, Float donGia, Double thanhTien) {
        this.maHD = ++nextMaHD;
        this.maKH = maKH;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuongTieuThu = soLuongTieuThu;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    public Integer getMaHD() {
        return maHD;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public LocalDate getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(LocalDate ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public Float getSoLuongTieuThu() {
        return soLuongTieuThu;
    }

    public void setSoLuongTieuThu(Float soLuongTieuThu) {
        this.soLuongTieuThu = soLuongTieuThu;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDon[" +
                "maHD=" + maHD +
                ", maKH=" + maKH +
                ", ngayRaHoaDon=" + ngayRaHoaDon +
                ", soLuongTieuThu=" + soLuongTieuThu +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                ']';
    }
}
