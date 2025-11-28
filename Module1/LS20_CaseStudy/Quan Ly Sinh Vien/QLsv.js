class SinhVien {
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
function hienThiSinhVien() {
  const tBody = document.querySelector("#bangsinhvien tbody"); // lấy phần body ở bảng
  tBody.innerHTML = ""; // xbooọ nội dung cũ để hiển thị lại

  danhSachSV.forEach((sv, index) => {
    const row = document.createElement("tr"); // tạo 1 hàng
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
        <button style="background-color: #58a9ffff;" onclick="suaSinhVien(${index})">Sửa</button>
        <button style="background-color: #fc7d7dff" onclick="xoaSinhVien(${index})">Xoá</button>
      </td>
      `;

    tBody.appendChild(row); // thêm hàng vào bảng
  });
}

function themSinhVien(sv) {
  danhSachSV.push(sv);
  hienThiSinhVien();
}

function xoaSinhVien(index) {
  danhSachSV.splice(index, 1);
  hienThiSinhVien();
}

function suaSinhVien(index) {
  const sv = danhSachSV[index];

  editingIndex = index;

  document.getElementById("mssv").value = sv.getMssv();
  document.getElementById("hoten").value = sv.getHoten();
  document.getElementById("chuyennganh").value = sv.getChuyenNganh();
  document.getElementById("ngaysinh").value = sv.getNgaySinh();
  document.getElementById("quequan").value = sv.getQueQuan();
  document.getElementById("email").value = sv.getEmail();
  document.getElementById("sdt").value = sv.getStd();
  document.querySelector(
    `input[name='gioitinh'][value='${sv.getGioiTinh()}']`
  ).checked = true;
}

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("themsinhvien");
  const timkiem = document.getElementById("timkiem");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const mssv = document.getElementById("mssv").value.trim();
    const hoten = document.getElementById("hoten").value.trim();
    const chuyennganh = document.getElementById("chuyennganh").value;
    const ngaysinh = document.getElementById("ngaysinh").value.trim();
    const quequan = document.getElementById("quequan").value.trim();
    const email = document.getElementById("email").value.trim();
    const sdt = document.getElementById("sdt").value.trim();
    const gioitinh = document.querySelector(
      'input[name="gioitinh"]:checked'
    ).value;
    if (!gioitinh) {
      alert("Vui lòng chọn giới tính!");
      return;
    }

    const sv = new SinhVien(
      mssv,
      hoten,
      chuyennganh,
      ngaysinh,
      quequan,
      email,
      sdt,
      gioitinh
    );

    if (editingIndex === -1) {
      themSinhVien(sv);
    } else {
      danhSachSV[editingIndex] = sv;
      editingIndex = -1;
      hienThiSinhVien();
    }

    form.reset();
  });

  timkiem.addEventListener("input", function () {
    const keyword = timkiem.value.toLowerCase();
    const rows = document.querySelectorAll("#bangsinhvien tbody tr");

    rows.forEach((row) => {
      const mssv = row.cells[0].innerText.toLowerCase();
      const hoten = row.cells[1].innerText.toLowerCase();

      if (mssv.includes(keyword) || hoten.includes(keyword)) {
        row.style.display = "";
      } else {
        row.style.display = "none";
      }
    });
  });
});
