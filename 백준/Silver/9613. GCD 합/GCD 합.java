import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //백준 - GCD 합
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
    public static void solution(int[] arr) {
        long answer = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int num1 = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int num2 = arr[j];
                answer += gcd(Math.max(num1,num2), Math.min(num1,num2));
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            solution(arr);
        }
    }
}
