package pj1;
import java.util.Scanner;

public class ss3 {
    public static Scanner sc = new Scanner(System.in);

    public static String readNumberOnes(int n) {
        String result = "";
        switch (n) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
                break;
            case 10:
                result = "Ten";
                break;
        }
        return result;
    }

    public static String readNumberTens(short n) {
        String result = "";
        switch (n) {
            case 2:
                result = "Twenty";
                break;
            case 3:
                result = "Thirty";
                break;
            case 4:
                result = "Forty";
                break;
            case 5:
                result = "Fifty";
                break;
            case 6:
                result = "Sixty";
                break;
            case 7:
                result = "Seventy";
                break;
            case 8:
                result = "Eighty";
                break;
            case 9:
                result = "Ninety";
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        String res = "";
        System.out.println("Nhập số cần đọc: ");
        int n = sc.nextInt();
        if (n >= 1000 || n <= 0) {
            res = "Out of ability";
        } else if (n <= 10) {
            res = readNumberOnes(n);
        } else if (n <= 20) {
            short temp = (short) (n - 10);
            if(n == 11){
                res = "eleven";
            }
            else if(n == 12){
                res = "twelve";
            }
            else if(n == 13){
                res = "thirteen";
            }
            else if(n == 14){
                res = "fourteen";
            }
            else if(n == 15){
                res = "fifteen";
            }else {
                res = readNumberOnes(temp) + "teen";
            }
        } else if (n < 100) {
            short tens = (short) (n/10);
            short ones = (short) (n%10);
            res = readNumberTens(tens) + " " + readNumberOnes(ones);
        }else {
            short hundred = (short) (n/100);
            short tens = (short) ((n%100)/10);
            short ones = (short) ((n%100)%10);
            res = readNumberOnes(hundred) + " hundred and " + readNumberTens(tens) + " " + readNumberOnes(ones);
        }
        System.out.println(res);
    }
}
