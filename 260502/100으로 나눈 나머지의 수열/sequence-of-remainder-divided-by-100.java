import java.util.Scanner;

public class Main {
    public static int n;
    public static int solution(int a, int b, int cnt){
        if(n==1) return 2;
        if(n==2) return 4;
        if(cnt>n) return b;
        return solution(b,a*b%100,++cnt);

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solution(2,4,3));
    }
}