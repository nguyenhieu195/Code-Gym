class SinhVien {
  constructor(mssv, hoten, chuyennganh, ngaysinh, quequan, email, sdt, gioitinh) {
    this.mssv = mssv;
    this.hoten = hoten;
    this.chuyennganh = chuyennganh;
    this.ngaysinh = ngaysinh;
    this.quequan = quequan;
    this.email = email;
    this.sdt = sdt;
    this.gioitinh = gioitinh;
  }

  // Getter
  getMssv() { return this.mssv; }
  getHoten() { return this.hoten; }
  getChuyenNganh() { return this.chuyennganh; }
  getNgaySinh() { return this.ngaysinh; }
  getQueQuan() { return this.quequan; }
  getEmail() { return this.email; }
  getSdt() { return this.sdt; }
  getGioiTinh() { return this.gioitinh; }

  // Setter
  setMssv(mssv) { this.mssv = mssv; }
  setHoTen(hoten) { this.hoten = hoten; }
  setChuyenNganh(chuyennganh) { this.chuyennganh = chuyennganh; }
  setNgaySinh(ngaysinh) { this.ngaysinh = ngaysinh; }
  setQueQuan(quequan) { this.quequan = quequan; }
  setEmail(email) { this.email = email; }
  setSdt(sdt) { this.sdt = sdt; }
  setGioiTinh(gioitinh) { this.gioitinh = gioitinh; }
}

// ================== QUẢN LÝ SINH VIÊN ==================
let danhSachSV = [];
let editingIndex = -1;

function renderTable() {
  const tableBody = document.querySelector("#bangsinhvien tbody");
  tableBody.innerHTML = "";

  danhSachSV.forEach((sv, index) => {
    const row = document.createElement("tr");

    row.innerHTML = `
      <td>${sv.getMssv()}</td>
      <td>${sv.getHoten()}</td>
      <td>${sv.getChuyenNganh()}</td>
      <td>${sv.getNgaySinh()}</td>
      <td>${sv.getQueQuan()}</td>
      <td>${sv.getEmail()}</td>
      <td>${sv.getSdt()}</td>
      <td>${sv.getGioiTinh()}</td>
      <td>
        <button onclick="suaSinhVien(${index})">Sửa</button>
        <button onclick="xoaSinhVien(${index})">Xóa</button>
      </td>
    `;

    tableBody.appendChild(row);
  });
}

function themSinhVien(sv) {
  danhSachSV.push(sv);
  renderTable();
}

function xoaSinhVien(index) {
  danhSachSV.splice(index, 1);
  renderTable();
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
  document.getElementById("sdt").value = sv.getSdt();
  document.querySelector(`input[name='gioitinh'][value='${sv.getGioiTinh()}']`).checked = true;
}

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("themsinhvien");
  const timKiem = document.getElementById("timkiem");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const mssv = document.getElementById("mssv").value.trim();
    const hoten = document.getElementById("hoten").value.trim();
    const chuyennganh = document.getElementById("chuyennganh").value;
    const ngaysinh = document.getElementById("ngaysinh").value;
    const quequan = document.getElementById("quequan").value.trim();
    const email = document.getElementById("email").value.trim();
    const sdt = document.getElementById("sdt").value.trim();
    const gioitinh = document.querySelector("input[name='gioitinh']:checked")?.value;

    if (!gioitinh) {
      alert("Vui lòng chọn giới tính!");
      return;
    }

    const sv = new SinhVien(mssv, hoten, chuyennganh, ngaysinh, quequan, email, sdt, gioitinh);

    if (editingIndex === -1) {
      themSinhVien(sv);
    } else {
      danhSachSV[editingIndex] = sv; // Cập nhật
      editingIndex = -1;
      renderTable();
    }

    form.reset();
  });

  // ✅ Tìm kiếm theo MSSV hoặc Họ tên
  timKiem.addEventListener("keyup", function () {
    const keyword = timKiem.value.toLowerCase();
    const rows = document.querySelectorAll("#bangsinhvien tbody tr");

    rows.forEach(row => {
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
