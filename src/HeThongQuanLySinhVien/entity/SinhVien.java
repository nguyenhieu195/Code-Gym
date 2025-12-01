package HeThongQuanLySinhVien.entity;

import java.time.LocalDate;

public class SinhVien extends Person {

    private Integer maSV;
    private static Integer nextIDmaSV = 0;

    private  String maLop;
    public SinhVien(Integer maSV,String hoTen, String gioiTinh, LocalDate ngaySinh, String soDT, String maLop) {
        super(hoTen, gioiTinh, ngaySinh, soDT);
        this.maSV = maSV;
        this.maLop = maLop;

        if(maSV > nextIDmaSV){
            nextIDmaSV = maSV;
        }
    }

    public SinhVien(String hoTen, String gioiTinh, LocalDate ngaySinh, String soDT, String maLop) {
        super(hoTen, gioiTinh, ngaySinh, soDT);
        this.maSV = ++nextIDmaSV;
        this.maLop = maLop;
    }

    public Integer getMaSV() {
        return maSV;
    }

    public void setMaSV(Integer maSV) {
        this.maSV = maSV;
    }

    public Integer getNextIDmaSV() {
        return nextIDmaSV;
    }

    public void setNextIDmaSV(Integer nextIDmaSV) {
        this.nextIDmaSV = nextIDmaSV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoten=" + getHoTen() +
                ", maSV=" + maSV +
                ", maLop='" + maLop + '\'' +
                '}';
    }
}
