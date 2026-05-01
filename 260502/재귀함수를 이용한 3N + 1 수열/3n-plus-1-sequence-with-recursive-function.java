import java.util.Scanner;
public class Main {
    public static int solution(int n, int answer){
        if(n==1) return answer;
        if(n%2==0) return solution(n/2,++answer);
        return solution(n*3+1,++answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(solution(n,0));
    }
}