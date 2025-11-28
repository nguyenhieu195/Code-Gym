let chieudai;
let chieurong;

chieudai = prompt("Nhập chiều dài");
chieurong = prompt("Nhập chiều rộng:");

// Sử dụng hàm parseInt() để chuyển kiểu dữ liệu từ chuỗi sang số nguyên.
let cd = parseInt(chieudai);
let cr = parseInt(chieurong);

let dientich = cd * cr;
document.writeln("Diện tích là: " + dientich);