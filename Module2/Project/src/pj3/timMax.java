package pj3;

public class timMax {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 200, 4},
                {5, 300, 7, 100}
        };
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] > max){
                    max = a[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
