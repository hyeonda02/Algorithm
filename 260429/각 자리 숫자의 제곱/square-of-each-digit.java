import java.util.*;

public class Main {
    public static int solution(int n){
        if(n<10){
            return (int)Math.pow(n,2);
        }else{
            return solution(n/10)+(int)Math.pow(n%10,2);
        }
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }
}