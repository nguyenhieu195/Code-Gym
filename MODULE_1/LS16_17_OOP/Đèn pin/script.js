class Pin {
  nangLuong;

  constructor(nangLuong) {
    this.nangLuong = nangLuong;
  }

  setNangLuong(nangLuong) {
    this.nangLuong = nangLuong;
  }

  getNangLuong() {
    return this.nangLuong;
  }

  giamnangLuong() {
    if(this.nangLuong > 0){
        this.nangLuong--;
    }
  }
}

class Den_Pin{
  trangThai;
  pin;
  constructor(trangThai, pin) {
    this.trangThai = trangThai;
    this.pin = pin;
  }

  ganPin(pin) {
    // gắn pin
    this.pin = pin;
  }

  layThongTinPin() {
    return "pin dang " + (this.trangThai ? "bật" : "tắt") + ", lượng pin còn " + this.pin.getNangLuong() + "%";
  }

  phatSang() {
    if (this.trangThai && this.pin.getNangLuong() > 0) {
      console.log("Đèn đang phát sáng!");
      this.pin.giamnangLuong();
    } else if (!this.trangThai) {
      console.log("Đèn đang tắt, không phát sáng!");
    } else {
      console.log("Pin yếu, đèn không thể phát sáng!");
    }
  }

  batDen() {
    if(this.pin.getNangLuong() > 0){
        this.trangThai = true;
        console.log("đèn đã được bật");
    }else{
        console.log("đèn yếu không thể bật");
    }
  }

  tatDen() {
    this.trangThai = false;
    console.log("đèn đã được tắt.");
  }
}


// Tạo pin và đèn pin
let pin = new Pin(10);
let den = new Den_Pin(false, pin);

console.log(den.layThongTinPin());
den.batDen();

// Phát sáng 12 lần để kiểm tra trạng thái pin
for(let i = 0; i < 12; i++) {
  den.phatSang();
  console.log(den.layThongTinPin());
}

den.tatDen();
console.log(den.layThongTinPin());