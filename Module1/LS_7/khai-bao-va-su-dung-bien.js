document.writeln('bai 1: <br/>')
let i = 10;
let f = 20.5;
let b = true;
let s = "ha noi"
document.writeln('int = ' + i);
document.writeln('<br/>')
document.writeln('float = ' + f);
document.writeln('<br/>')
document.writeln('boolean = ' + b);
document.writeln('<br/>')
document.writeln('string = ' + s);
document.writeln('<br/>')
document.writeln('--------------------<br/>')

document.writeln('bai 2: <br/>')
let chieuDai = 5;
let chieuRong = 10;
let chiVi = (chieuDai + chieuRong) * 2;
let dienTich = chieuDai * chieuRong;
document.writeln('Chiều dài = ' + chieuDai + "<br/>");
document.writeln('Chiều rộng = ' + chieuRong + "<br/>");
document.writeln('Chu vi = ' + chiVi + '<br/>');
document.writeln('Diện tích = ' + dienTich + '<br/>');
document.writeln('--------------------<br/>')

document.writeln('bai 3: <br/>')
let x = prompt("Nhập biến x");
let y = prompt("Nhập biến y");
if(x % y == 0){
    alert("x là bội số của y");
}
else{
    alert("x khong phải là bội số của y !");
}