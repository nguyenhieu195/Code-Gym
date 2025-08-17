function number(nums){
    document.getElementById("result").value += nums;
}
function phimBang(){
    let Result = eval(document.getElementById("result").value);
    document.getElementById("result").value = Result;
}
function xoa(){
    document.getElementById('result').value = '';
}
function phepCong(){
    document.getElementById("result").value += " + ";
}
function phepTru(){
    document.getElementById('result').value += " - ";
}
function phepNhan(){
    document.getElementById('result').value += " * ";
}
function phepChia(){
    document.getElementById('result').value += ' / ';
}
function phanTram(){
    let phantram = (eval(document.getElementById('result').value));
    document.getElementById('result').value = phantram / 100;
}
function giaiThua(){
    document.getElementById('result').value += "!";
}