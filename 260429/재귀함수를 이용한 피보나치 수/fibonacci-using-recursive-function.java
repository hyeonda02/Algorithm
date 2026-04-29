import java.util.Scanner;

public class Main {
    public static int fibo(int n){
        if(n==1||n==2) return 1;
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibo(n));
    }
}