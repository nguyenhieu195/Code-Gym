class sinhvien {
  mssv;
  hoten;
  chuyennganh;
  ngaysinh;
  quequan;
  email;
  sdt;
  gioitinh;

  constructor(
    mssv,
    hoten,
    chuyennganh,
    ngaysinh,
    quequan,
    email,
    sdt,
    gioitinh
  ) {
    this.mssv = mssv;
    this.chuyennganh = chuyennganh;
    this.hoten = hoten;
    this.ngaysinh = ngaysinh;
    this.quequan = quequan;
    this.email = email;
    this.sdt = sdt;
    this.gioitinh = gioitinh;
  }

  setMssv(mssv) {
    this.mssv = mssv;
  }
  setHoTen(hoten) {
    this.hoten = hoten;
  }
  setChuyenNganh(chuyennganh) {
    this.chuyennganh = chuyennganh;
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

  getMssv() {
    return this.mssv;
  }
  getHoten() {
    return this.hoten;
  }
  getChuyenNganh() {
    return this.chuyennganh;
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
 
let danhSachSV = [];
let editingIndex = -1;

// Hiển thị ra danh sách sinh viên ở bảng
function hienThiSinhVien(){
  const tBody = document.querySelector(#bangsinhvien tbody); // lấy phần body ở bảng
  tBody.innerHTML = "";

  danhSachSV.forEach((sv, index) => {
    const row = document.createElement('tr'); // tạo 1 hàng
    row.innerHTML = `
      <td>${sv.getMssv()}</td>
      <td>${sv.getHoten()}</td>
      <td>${sv.getChuyenNganh()}</td>
      <td>${sv.getNgaySinh()}</td>
      <td>${sv.getQueQuan()}</td>
      <td>${sv.getEmail()}</td>
      <td>${sv.getStd()}</td>
      <td>${sv.getGioiTinh()}</td>
      <td>
        <button onclick="suaSV('index')">Sửa</button>
        <button onclick="xoaSV('index')">Xoá</button>
      </td>
      `;
      
      
  })
}

function themSinhVien(sv){
  danhSachSV.push(sv);
}


