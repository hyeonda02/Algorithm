import java.util.Scanner;
public class Main {
    public static void decrease(int n) {
        if(n==0) return;
        System.out.print(n + " ");
        decrease(n-1);
    }
    public static void increase(int n){
        if(n==0) return;
        increase(n-1);
        System.out.print(n +" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        decrease(n);
        increase(n);
    }
}