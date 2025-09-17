let students = JSON.parse(localStorage.getItem("students")) || [];

const form = document.getElementById("themsinhvien");
const tbody = document.querySelector("#bangsinhvien tbody");
let editingRow = null;

form.addEventListener("submit", function (e) {
  e.preventDefault(); // Khi bấm “Thêm sinh viên”, trình duyệt không reload lại trang

  const mssv = document.getElementById("mssv").value.trim(); // trim() : là hàm chuỗi (string method) dùng để xóa bỏ khoảng trắng ở đầu và cuối chuỗi.
  const hoten = document.getElementById("hoten").value.trim();
  const chuyennganh = document.getElementById("chuyennganh").value;
  const ngaysinh = document.getElementById("ngaysinh").value;
  const quequan = document.getElementById("quequan").value.trim();
  const email = document.getElementById("email").value.trim();
  const sodt = document.getElementById("sdt").value.trim();
  const gioitinh = document.querySelector(
    "input[name='gioitinh']:checked"
  ).value;

  if (editingRow) {
    // sửa thong tin sinh viên
    editingRow.cells[0].innerText = mssv;
    editingRow.cells[1].innerText = hoten;
    editingRow.cells[2].innerText = chuyennganh;
    editingRow.cells[3].innerText = ngaysinh;
    editingRow.cells[4].innerText = quequan;
    editingRow.cells[5].innerText = email;
    editingRow.cells[6].innerText = sodt;
    editingRow.cells[7].innerText = gioitinh;

    editingRow = null;
    form.querySelector("input[type='submit']").value = "Thêm sinh viên";
  } else {
    //Thêm sinh viên mới
    const row = tbody.insertRow();

    row.insertCell(0).innerText = mssv;
    row.insertCell(1).innerText = hoten;
    row.insertCell(2).innerText = chuyennganh;
    row.insertCell(3).innerText = ngaysinh;
    row.insertCell(4).innerText = quequan;
    row.insertCell(5).innerText = email;
    row.insertCell(6).innerText = sodt;
    row.insertCell(7).innerText = gioitinh;

    // nút hành động
    const actions = row.insertCell(8);
    actions.innerHTML = `<button onclick="editRow(this)">Sửa</button> <button onclick="deleteRow(this)">Xoá</button>`;
  }

  form.reset();
});

function deleteRow(btn) {
  if (confirm("Bạn có chắc muốn xoá sinh viên này ?")) {
    btn.parentElement.parentElement.remove(); // → lấy thẻ ông (cha của cha) của btn.
    // <td> -> <tr>
  }
}

function editRow(btn) {
  editingRow = btn.parentElement.parentElement;

  document.getElementById("mssv").value = editingRow.cells[0].innerText;
  document.getElementById("hoten").value = editingRow.cells[1].innerText;
  document.getElementById("chuyennganh").value = editingRow.cells[2].innerText;
  document.getElementById("ngaysinh").value = editingRow.cells[3].innerText;
  document.getElementById("quequan").value = editingRow.cells[4].innerText;
  document.getElementById("email").value = editingRow.cells[5].innerText;
  document.getElementById("sdt").value = editingRow.cells[6].innerText;

  const gt = editingRow.cells[7].innerText;
  document.querySelector(`input[name='gioitinh'][value='${gt}']`).checked = true;

  form.querySelector(`input[type='submit']`).value = "Cập nhật";
}
