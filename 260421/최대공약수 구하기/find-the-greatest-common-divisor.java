import java.util.Scanner;

public class Main {
    public static void getGcd(int n, int m){
        if(m==0) System.out.println(n);
        else getGcd(m,n%m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        getGcd(n,m);
    }
}