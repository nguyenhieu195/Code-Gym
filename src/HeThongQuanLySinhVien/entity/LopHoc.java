package HeThongQuanLySinhVien.entity;

public class LopHoc {

    private String maLop;
    private String tenLop;
    private Integer maGV;

    public LopHoc(String maLop, String tenLop, Integer maGV) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGV = maGV;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLop=" + maLop +
                ", tenLop='" + tenLop + '\'' +
                ", maGV=" + maGV +
                '}';
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Integer getMaGV() {
        return maGV;
    }

    public void setMaGV(Integer maGV) {
        this.maGV = maGV;
    }
}
