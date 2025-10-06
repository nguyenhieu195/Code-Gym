class Apple {
  weight;

  constructor(weight) {
    this.weight = weight;
  }
  decrease() {
    // Giảm khối lượng táo đi 1 đơn vị
    if (this.weight > 0) {
      this.weight--;
    }
  }
  isEmpty() {
    // Kiểm tra xem còn táo không
    return this.weight === 0;
  }
  getWeight() {
    // lấy khối lượng táo
    return this.weight;
  }
}
class Human {
  name;
  gender;
  weight;

  constructor(name, gender, weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
  }
  isMale() {
    // kiểm tra xem phải giới tính nam khôgn
    return this.gender;
  }
  setGender(gender) {
    // đặt lại giới tính
    this.gender = gender;
  }
  getGender() {
    return this.gender;
  }
  checkApple(Apple) {
    // kiểm tra xem còn táo không
    return !Apple.isEmpty(); // true nếu còn
  }
  eat(Apple) {
    // ăn táo
    if (this.checkApple(Apple)) {
      Apple.decrease(); // giảm táo
      this.weight += 1; // tăng cân

      console.log(
        `số táo còn lại của là: ${Apple.getWeight()}, Người đã ăn là: ${this.getName()}, giới tính: ${
          this.isMale() ? "Nam" : "Nu"
        }, cân nặng hiện tại là: ${this.getWeight()}`
      );
    } else {
      console.log("đã hết táo !");
    }
  }
  say() {
    // giới thiệu
    console.log(
      `Tôi là ${this.getName()}, giới tính ${
        this.isMale() ? "Nam" : "Nu"
      }, cân nặng hiện tại ${this.getWeight()}`
    );
  }
  getName() {
    return this.name;
  }
  setName(name) {
    this.name = name;
  }
  getWeight() {
    return this.weight;
  }
  setWeight(weight) {
    this.weight = weight;
  }
}

let apple = new Apple(10);

let adam = new Human("Hieu", true, 55);
let eva = new Human("Nha", false, 45);

adam.say();
eva.say();

console.log("Bắt đầu ăn táo----------->");

while (!apple.isEmpty()) {
  adam.eat(apple);
  if (apple.isEmpty()) break;
  eva.eat(apple);
}

console.log("----------->Đã ăn hết táo");
adam.say();
eva.say();
