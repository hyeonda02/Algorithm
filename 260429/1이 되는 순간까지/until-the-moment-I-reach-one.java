import java.util.Scanner;
public class Main {
    public static int answer;
    public static void solution(int n){
        if(n==1) return;
        answer++;
        if(n%2==0) {
            solution(n/2);
        }else{
            solution(n/3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        solution(n);
        System.out.println(answer);
        
    }
}