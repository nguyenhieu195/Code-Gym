package pj2;

public class hienThi20SNTdauTien {
    public static boolean snt(int x) {
        if (x < 2) return false;

        if (x == 2) return true;

        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int dem = 0;
        for (int i = 0; dem < 20; i++) {
            if (snt(i)) {
                System.out.print(i + " ");
                dem++;
            }
        }
    }
}
