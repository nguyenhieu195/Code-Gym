package pj2;

public class SNTbeHon100 {
    public static boolean snt(int x) {
        if (x < 2) return false;

        if (x == 2) return true;

        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (snt(i)) {
                System.out.println(i + " ");
            }
        }
    }
}
