function DoiTien(){
    let giaTien = Number(document.getElementById("soTien").value);
    let From = document.getElementById("truocChuyenDoi").value;
    let To = document.getElementById("sauChuyenDoi").value;

    let ketqua;

    if(From == "USD" && To == "VND"){
        ketqua = "Thành tiền: " + 23000 * giaTien + " VND";
    }
    else if(From == "VND" && To == "USD"){
        ketqua = "Thành tiền: " + "$" + (giaTien / 23000);
    }
    else if(From == "VND" && To == "VND"){
        ketqua = "Thành tiền: " + giaTien + " VND";
    }
    else{
        ketqua = "Thành tiền: " + "$" + giaTien;
    }
    document.getElementById("trave").innerHTML = ketqua;
}