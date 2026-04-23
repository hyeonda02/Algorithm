import java.util.Scanner;

public class Main {
    public static String isMagicNum(int n){
        int sum = n/10 + n%10;
        if(sum%5==0&&n%2==0) return "Yes";
        return "No";

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isMagicNum(n));
    }
}