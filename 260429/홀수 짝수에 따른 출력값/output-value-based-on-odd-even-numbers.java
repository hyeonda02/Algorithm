import java.util.*;

public class Main {
    public static int solution(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return n + solution(n-2);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }
}