// Lấy các phần tử từ DOM
const form = document.getElementById("themsinhvien");
const tableBody = document.querySelector("#bangsinhvien tbody");
const searchInput = document.getElementById("timkiem");

let sinhVienList = JSON.parse(localStorage.getItem("sinhVienList")) || [];
let editingIndex = -1; // Biến để biết đang sửa sinh viên nào

// Hàm hiển thị danh sách sinh viên
function hienThiSinhVien(list = sinhVienList) {
    tableBody.innerHTML = "";
    list.forEach((sv, index) => {
        let row = `
            <tr>
                <td>${sv.mssv}</td>
                <td>${sv.hoten}</td>
                <td>${sv.chuyennganh}</td>
                <td>${sv.ngaysinh}</td>
                <td>${sv.quequan}</td>
                <td>${sv.email}</td>
                <td>${sv.sdt}</td>
                <td>${sv.gioitinh}</td>
                <td>
                    <button onclick="suaSinhVien(${index})">Sửa</button>
                    <button onclick="xoaSinhVien(${index})" style="background:red;color:white;">Xóa</button>
                </td>
            </tr>
        `;
        tableBody.innerHTML += row;
    });
}

// Hàm thêm hoặc sửa sinh viên
form.addEventListener("submit", function (e) {
    e.preventDefault();

    const sv = {
        mssv: document.getElementById("mssv").value.trim(),
        hoten: document.getElementById("hoten").value.trim(),
        chuyennganh: document.getElementById("chuyennganh").value,
        ngaysinh: document.getElementById("ngaysinh").value,
        quequan: document.getElementById("quequan").value.trim(),
        email: document.getElementById("email").value.trim(),
        sdt: document.getElementById("sdt").value.trim(),
        gioitinh: document.querySelector("input[name='gioitinh']:checked").value
    };

    if (editingIndex === -1) {
        // Thêm mới
        sinhVienList.push(sv);
    } else {
        // Cập nhật
        sinhVienList[editingIndex] = sv;
        editingIndex = -1;
    }

    localStorage.setItem("sinhVienList", JSON.stringify(sinhVienList));
    hienThiSinhVien();
    form.reset();
});

// Hàm xóa sinh viên
function xoaSinhVien(index) {
    if (confirm("Bạn có chắc muốn xóa sinh viên này không?")) {
        sinhVienList.splice(index, 1);
        localStorage.setItem("sinhVienList", JSON.stringify(sinhVienList));
        hienThiSinhVien();
    }
}

// Hàm sửa sinh viên
function suaSinhVien(index) {
    const sv = sinhVienList[index];
    document.getElementById("mssv").value = sv.mssv;
    document.getElementById("hoten").value = sv.hoten;
    document.getElementById("chuyennganh").value = sv.chuyennganh;
    document.getElementById("ngaysinh").value = sv.ngaysinh;
    document.getElementById("quequan").value = sv.quequan;
    document.getElementById("email").value = sv.email;
    document.getElementById("sdt").value = sv.sdt;

    const radios = document.getElementsByName("gioitinh");
    radios.forEach(r => {
        r.checked = (r.value === sv.gioitinh);
    });

    editingIndex = index;
}

// Hàm tìm kiếm
searchInput.addEventListener("keyup", function () {
    const keyword = this.value.toLowerCase();
    const filtered = sinhVienList.filter(sv =>
        sv.mssv.toLowerCase().includes(keyword) ||
        sv.hoten.toLowerCase().includes(keyword) ||
        sv.chuyennganh.toLowerCase().includes(keyword) ||
        sv.quequan.toLowerCase().includes(keyword)
    );
    hienThiSinhVien(filtered);
});

// Khi load trang thì hiển thị sinh viên
document.addEventListener("DOMContentLoaded", hienThiSinhVien);
