import java.util.Scanner;
public class Main {
    static int[] arr;
    public static int solution(int a, int b){
        int result = 0;
        for(int i=a-1;i<b;i++){
            result += arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            // Please write your code here.
            System.out.println(solution(a1,a2));
        }
    }
}