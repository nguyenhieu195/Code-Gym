package pj11_Stack_Map_Queue;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class demSoLanXuatHienCuaMoiTu_Map {
    public static void main(String[] args) {
        String input = "Nguyen van hieu hieu nguyen tran dinh hieu hiue hieu1324";
        String[] word = input.split("\\s+");
        // Dùng TreeMap để lưu từ (key) và số lần xuất hiện (value)
        TreeMap<String, Integer> map = new TreeMap<>();

        //Duyet tung tu trong chuoi
        for (String w :  word){
            w = w.toLowerCase(); // chuyen chu hoa thanh chu thuong

            // nếu map đã có key này thì tăng value lên 1
            if(map.containsKey(w)){
                map.put(w, map.get(w) +1);
            }else{
                // nếu chưa có thì thêm mới, gán value = 1
                map.put(w, 1);
            }
        }

        System.out.println("Số lần xuất hiện của mỗi từ: ");
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
