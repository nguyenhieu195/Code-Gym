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
    if(this.pin.tra)
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
