import java.util.Scanner;
public class Main {
    public static int solution(int n){
        if(n==1) return 0;
        if(n%2==0) return solution(n/2)+1;
        return solution(n*3+1)+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(solution(n));
    }
}