import java.util.*;

public class Main {
    public static void solution(int n){
        if(n==0) return;
        solution(n-1);
        System.out.println("HelloWorld");
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        solution(N);
    }
}