function phepCong(){
    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    document.getElementById("ketqua").innerHTML = a + b;
}
function phepTru(){
    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    document.getElementById("ketqua").innerHTML = a - b;
}
function phepNhan(){
    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);
    document.getElementById("ketqua").innerHTML = a * b;
}
function phepChia(){
    let a = Number(document.getElementById("num1").value);
    let b = Number(document.getElementById("num2").value);

    if(b === 0){
        document.getElementById("ketqua").innerHTML = "Không thể chia cho 0!";
    } else {
        document.getElementById("ketqua").innerHTML = a / b;
    }
}