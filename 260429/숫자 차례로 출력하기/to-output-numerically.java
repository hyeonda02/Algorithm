import java.util.*;

public class Main {
    public static void increase(int n){
        if(n==0) return;
        increase(n-1);
        System.out.print(n+" ");
    }
    public static void decrease(int n){
        if(n==0) return;
        System.out.print(n+" ");
        decrease(n-1);
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        increase(n);
        System.out.println();
        decrease(n);
    }
}