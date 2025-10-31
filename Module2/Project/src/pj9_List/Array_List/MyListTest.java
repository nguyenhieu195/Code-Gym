package pj9_List.Array_List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("nguyễn");
        list.add("văn");
        list.add("hiếu");
        list.add("quảng");
        list.add("trị");
        list.add("74");

        System.out.println("-Mảng ban đầu: ");
        list.display();

        System.out.println("-Thêm phần tử 'đẹp trai vào vị trí 4'");
        list.add(3, "đẹp trai");
        list.display();

        System.out.println("-Xoá phần tử tại vị trí 1");
        list.remove(1);
        list.display();

        System.out.println("-Kiểm tra xem có chứa phần tử 'hiếu' không?\n" + list.contains("hiếu"));

        System.out.println("-Copy cho mảng mới");
        MyList<String> newList = list.clone();
        newList.add("dev");
        newList.display();
    }
}
