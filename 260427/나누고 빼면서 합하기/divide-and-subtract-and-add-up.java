import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int answer;
    public static void solution(int m){
        answer += arr[m];
        if(m==1) return;
        if(m%2==0) {
            solution(m/2);
        }else {
            solution(m-1);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        solution(m);
        System.out.println(answer);
    }
}