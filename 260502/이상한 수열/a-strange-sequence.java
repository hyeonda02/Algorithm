import java.util.Scanner;
public class Main {
    public static int solution(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return solution(Math.abs(n/3))+solution(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(solution(n));
    }
}