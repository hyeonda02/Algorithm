import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int g = arr[0];
        int l = arr[0];

        for(int i=1; i<n;i++){
            g = gcd(g,arr[i]);
            l = lcm(l,arr[i]);
        }

        System.out.println(l);
    }
}