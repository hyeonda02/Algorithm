import java.util.*;

public class Main {
    public static int solution(int n){
        if(n<10) return n;
        return n%10+solution(n/10);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
       
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(solution(a*b*c));
    }
}