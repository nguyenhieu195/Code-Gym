package pj3;

public class demKiTu {
    public static void main(String[] args) {
        String ten = "Nguyen Van Hieu Dai Hoc Duy Tan";
        char kitu = 'a';
        int dem = 0;

        for (int i = 0; i < ten.length(); i++) {
            if (ten.charAt(i) == kitu) {
                dem++;
            }
        }

        System.out.println(dem);
    }
}
