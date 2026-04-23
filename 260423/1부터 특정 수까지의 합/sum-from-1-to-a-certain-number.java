import java.util.Scanner;

public class Main {
    static int solution(int N){
        int sum = 0;
        for(int i=1;i<=N;i++){
            sum += i;
        }
        return sum/10;

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(solution(N));

    }
}