function DoiTien(){
    let giaTien = Number(document.getElementById("soTien").value);
    let From = document.getElementById("truocChuyenDoi").value;
    let To = document.getElementById("sauChuyenDoi").value;

    let ketqua;

    if(From == "USD" && To == "VND"){
        ketqua = 23000 * giaTien + " VND";
    }
    else if(From == "VND" && To == "USD"){
        ketqua = "$" + (giaTien / 23000);
    }
    else if(From == "VND" && To == "VND"){
        ketqua = giaTien + " VND";
    }
    else{
        ketqua = "$" + giaTien;
    }
    document.getElementById("trave").innerHTML = ketqua;
}