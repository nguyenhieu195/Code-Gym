class HinhChuNhat {
  chieudai;
  chieurong;

  constructor(chieudai, chieurong) {
    this.chieudai = chieudai;
    this.chieurong = chieurong;
  }

  DienTich() {
    return this.chieudai * this.chieurong;
  }
  ChuVi() {
    return (this.chieudai + this.chieurong) * 2;
  }
}

let ChuNhat = new HinhChuNhat(300, 100);

console.log(ChuNhat.ChuVi());
console.log(ChuNhat.DienTich());

let canvas = document.getElementById("myCanvas");
let ctx = canvas.getContext("2d");
ctx.fillStyle = "red"; // màu hình chữ nhật
ctx.fillRect(10, 10, ChuNhat.chieudai, ChuNhat.chieurong); // 10, 10 là toạ độ để hiển thị hình chữ nhật
