// var intro = "Hello world!";
// document.getElementById("intro").innerHTML = intro;
// function do_something(){
//     var selectedValue = document.getElementById("mySelect").value;
//     alert(selectedValue);
// }
var selectedElement = document.getElementById("mySelect");
selectedElement.addEventListener("change", changeFunction);
function changeFunction(){
    var selectedValue = document.getElementById("mySelect").value;
    alert(selectedValue)
}