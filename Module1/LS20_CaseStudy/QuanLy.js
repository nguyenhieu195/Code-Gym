class Person {
  hoten;
  ngaysinh;
  quequan;
  email;
  sdt;
  gioitinh;
  constructor(hoten, ngaysinh, quequan, email, sdt, gioitinh) {
    this.hoten = hoten;
    this.ngaysinh = ngaysinh;
    this.quequan = quequan;
    this.email = email;
    this.sdt = sdt;
    this.gioitinh = gioitinh;
  }

  setHoTen(hoten) {
    this.hoten = hoten;
  }
  setNgaySinh(ngaysinh) {
    this.ngaysinh = ngaysinh;
  }
  setQueQuan(quequan) {
    this.quequan = quequan;
  }
  setEmail(email) {
    this.email = email;
  }
  setSdt(sdt) {
    this.sdt = sdt;
  }
  setGioiTinh(gioitinh) {
    this.gioitinh = gioitinh;
  }

  getHoten() {
    return this.hoten;
  }
  getNgaySinh() {
    return this.ngaysinh;
  }
  getQueQuan() {
    return this.quequan;
  }
  getEmail() {
    return this.email;
  }
  getStd() {
    return this.sdt;
  }
  getGioiTinh() {
    return this.gioitinh;
  }
}

class LopHoc {
  malop;
  tenlop;

  constructor(malop, tenlop) {
    this.malop = malop;
    this.tenlop = tenlop;
  }

  setMaLop(malop) {
    this.malop = malop;
  }
  setTenLop(tenlop) {
    this.tenlop = tenlop;
  }

  getMaLop() {
    return this.malop;
  }
  getTenLop() {
    return this.tenlop;
  }
}

class SinhVien extends Person {
  masv;
  chuongtrinhhoc; // thường va quôc tế
  lopHoc;

  constructor(
    masv,
    chuongtrinhhoc,
    hoten,
    ngaysinh,
    quequan,
    email,
    sdt,
    gioitinh,
    lopHoc
  ) {
    super(hoten, ngaysinh, quequan, email, sdt, gioitinh, lopHoc);
    this.masv = masv;
    this.chuongtrinhhoc = chuongtrinhhoc;
    this.lopHoc = lopHoc;
  }
  setMasv(masv) {
    this.masv = masv;
  }
  getMasv() {
    return this.masv;
  }

  setChuongTrinhHoc(chuongtrinhhoc) {
    this.chuongtrinhhoc = chuongtrinhhoc;
  }
  getChuogntrinhHoc() {
    return this.chuongtrinhhoc;
  }

  setLopHoc(lopHoc){
    this.lopHoc = lopHoc;
  }
  getLopHoc(){
    return this.lopHoc;
  }

  HocPhi(){
    if(this.getChuogntrinhHoc.toLowerCase() == "thuong"){
        return "10 triệu";
    }else{
        return "20 triệu"
    }
  }
}
class GiangVien extends Person{
    magv;
    hocvi; // cử nhân, thạc sĩ, tiến sĩ, giáo sư, phó giáo sư
    lopChuNhiem;
    luongcoban;
    constructor(magv, hoten, hocvi, ngaysinh, quequan, email, sdt, gioitinh, lopChuNhiem, luongcoban) {
        super(hoten, ngaysinh, quequan, email, sdt, gioitinh);
        this.magv = magv;
        this.hocvi = hocvi;
        this.lopChuNhiem = lopChuNhiem;
        this.luongcoban = luongcoban;
    }

    setMagv(magv){
        this.magv = magv;
    }
    getMagv(){
        return this.magv;
    }

    setLuongCoBan(luongcoban){
        this.luongcoban = luongcoban;
    }
    getLuongCoBan(){
        return this.luongcoban;
    }
    
    setHocVi(hocvi){
        this.hocvi = hocvi;
    }
    getHocVi(){
        return this.hocvi;
    }
    
    setLopChuNhiem(lopChuNhiem){
        this.lopChuNhiem = lopChuNhiem;
    }
    getLopChuNhiem(){
        return this.lopChuNhiem;
    }

}

let DS_LopHoc = [];
let DS_GiangVien = [];

class QL_SinhVien{
    DS_SinhVien = [];

    hienThiDanhSachSV(){    
        data = "<tr>"
        for(let i  = 0; i < this.DS_SinhVien.length; i++){
            data += `<td>${this.DS_SinhVien[i]}</td>`;
        }
        data += "</tr>";
    }

    xoaSinhVien(index){
        this.DS_SinhVien.splice(index, 1);
    }

    suaTTsinhVien(index){

    }
}