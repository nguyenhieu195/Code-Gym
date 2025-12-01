package HeThongQuanLySinhVien.entity;

import java.time.LocalDate;

public class GiangVien extends Person{

    private Integer maGV;
    private Integer nextIDmaGV = 0;

    public GiangVien(Integer maGV, String hoTen, String gioiTinh, LocalDate ngaySinh, String soDT) {
        super(hoTen, gioiTinh, ngaySinh, soDT);
        this.maGV = maGV;
        if(maGV > nextIDmaGV){
            nextIDmaGV = maGV;
        }
    }

    public GiangVien(String hoTen, String gioiTinh, LocalDate ngaySinh, String soDT) {
        super(hoTen, gioiTinh, ngaySinh, soDT);
        this.maGV = ++nextIDmaGV;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "maGV=" + maGV +
                ", nextIDmaGV=" + nextIDmaGV +
                '}';
    }

    public Integer getMaGV() {
        return maGV;
    }

    public void setMaGV(Integer maGV) {
        this.maGV = maGV;
    }

    public Integer getNextIDmaGV() {
        return nextIDmaGV;
    }

    public void setNextIDmaGV(Integer nextIDmaGV) {
        this.nextIDmaGV = nextIDmaGV;
    }
}
