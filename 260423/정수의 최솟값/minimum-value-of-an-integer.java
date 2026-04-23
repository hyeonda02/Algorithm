import java.util.Scanner;

public class Main {
    public static int getMin(int a, int b, int c){
        return Math.min(c,Math.min(a,b));
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(getMin(a,b,c));
    }
}